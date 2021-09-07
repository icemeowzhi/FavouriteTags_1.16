package com.imz.favourite_tags.capability.player_fed_up_capability;

import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.network.NetworkHandler;
import com.imz.favourite_tags.network.PlayerFedUpPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = FavouriteTag.MODID)
public class PlayerFedUpCapabilitySynchronizer {
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        //末地到主世界的同步
        if (!event.isWasDeath()) {
            LazyOptional<IPlayerFedUpCapability> oldSpeedCap = event.getOriginal().getCapability(CapabilityHandler.PLAYER_FED_UP_CAPABILITY);
            LazyOptional<IPlayerFedUpCapability> newSpeedCap = event.getPlayer().getCapability(CapabilityHandler.PLAYER_FED_UP_CAPABILITY);
            if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
                newSpeedCap.ifPresent((newCap) -> oldSpeedCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
            }
        }else {
            //死亡刷新
            LazyOptional<IPlayerFedUpCapability> playerFedUpCapability = event.getPlayer().getCapability(CapabilityHandler.PLAYER_FED_UP_CAPABILITY);
            playerFedUpCapability.ifPresent((capability) -> {
                CompoundNBT newNbt = new PlayerFedUpCapabilityProvider(event.getPlayer()).serializeNBT();
                //应用到服务端
                capability.deserializeNBT(newNbt);
                //发包同步
                if (!event.getPlayer().getEntityWorld().isRemote()) {
                    NetworkHandler.INSTANCE.send(
                            PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
                            new PlayerFedUpPack(newNbt));
                    event.getPlayer().sendStatusMessage(new TranslationTextComponent("fed_up.refresh.message"), true);
                }
            });
        }
    }

    //每次进入世界时，同步IPlayerFedUpCapability到客户端。
    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinWorldEvent event){
        if (event.getEntity() instanceof PlayerEntity){
            if (!event.getWorld().isRemote) {
                LazyOptional<IPlayerFedUpCapability> playerFedUpCap = event.getEntity().getCapability(CapabilityHandler.PLAYER_FED_UP_CAPABILITY);
                if (playerFedUpCap.isPresent()) {
                    playerFedUpCap.ifPresent((cap) -> {
                        NetworkHandler.INSTANCE.send(
                                PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getEntity()),
                                new PlayerFedUpPack(cap.serializeNBT()));
                    });
                }
            }
        }
    }
}
