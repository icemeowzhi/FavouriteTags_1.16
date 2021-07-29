package com.imz.favourite_tags.capability;

import com.imz.favourite_tags.network.NetworkHandler;
import com.imz.favourite_tags.network.PlayerTagCapPack;
import com.imz.favourite_tags.util.Constants;
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

@Mod.EventBusSubscriber
public class CapabilitySync {
    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
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
        if (event.getEntity() instanceof PlayerEntity){
            if (!event.getWorld().isRemote) {
                LazyOptional<IPlayerTagCapability> playerTagCap = event.getEntity().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
                if (playerTagCap.isPresent()) {
                    playerTagCap.ifPresent((cap) -> {
                        if (!event.getWorld().isRemote) {
                            NetworkHandler.INSTANCE.send(
                                    PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getEntity()),
                                    new PlayerTagCapPack(cap.serializeNBT()));
                        }
                    });
                }
            }
        }
    }

}

