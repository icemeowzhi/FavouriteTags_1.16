package com.imz.favourite_tags.capability.player_tag_capability;

import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.network.NetworkHandler;
import com.imz.favourite_tags.network.PlayerTagCapPack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = FavouriteTag.MODID)
public class PlayerTagCapabilitySynchronizer {
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        //降低优先级，保证PlayerFedUpCapability在之前加载
        event.setPhase(EventPriority.LOW);
        //末地到主世界的同步
        if (!event.isWasDeath()) {
            LazyOptional<IPlayerTagCapability> oldSpeedCap = event.getOriginal().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            LazyOptional<IPlayerTagCapability> newSpeedCap = event.getPlayer().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
                newSpeedCap.ifPresent((newCap) -> oldSpeedCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
            }
        }else {
            //死亡刷新
            LazyOptional<IPlayerTagCapability> playerTagCapability = event.getPlayer().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            playerTagCapability.ifPresent((capability) -> {
                CompoundNBT newNbt = new PlayerTagCapabilityProvider(event.getPlayer()).serializeNBT();
                //应用到服务端
                capability.deserializeNBT(newNbt);
                //发包同步
                if (!event.getPlayer().getEntityWorld().isRemote()){
                    NetworkHandler.INSTANCE.send(
                            PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
                            new PlayerTagCapPack(newNbt));
                    event.getPlayer().sendStatusMessage(new TranslationTextComponent("tag.refresh.message"),true);
                }

            });
        }
    }

    //每次进入世界时，同步IPlayerTagCapability到客户端。
    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinWorldEvent event){
        event.setPhase(EventPriority.LOW);
        if (event.getEntity() instanceof PlayerEntity){
            if (!event.getWorld().isRemote) {
                LazyOptional<IPlayerTagCapability> playerTagCap = event.getEntity().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
                if (playerTagCap.isPresent()) {
                    playerTagCap.ifPresent((cap) -> {
                            NetworkHandler.INSTANCE.send(
                                    PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getEntity()),
                                    new PlayerTagCapPack(cap.serializeNBT()));
                    });
                }
            }
        }
    }
}
