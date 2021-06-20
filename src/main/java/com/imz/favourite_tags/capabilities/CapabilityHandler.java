package com.imz.favourite_tags.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CapabilityHandler {
    @CapabilityInject(IPlayerTagCapability.class)
    public static Capability<IPlayerTagCapability> PLAYER_TAG_CAPABILITY;

    @CapabilityInject(IFoodTagCapability.class)
    public static Capability<IFoodTagCapability> FOOD_TAG_CAPABILITY;
}
