package com.imz.favourite_tags.capabilities;

import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

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
            //TODO
            LazyOptional<IPlayerTagCapability> oldSpeedCap = event.getOriginal().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            LazyOptional<IPlayerTagCapability> newSpeedCap = event.getPlayer().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
                newSpeedCap.ifPresent((newCap) -> oldSpeedCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
            }

        }

    }

}
