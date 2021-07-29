package com.imz.favourite_tags.network;

import com.imz.favourite_tags.util.Constants;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class NetworkHandler {
    public static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessage() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(Constants.MODID, "first_networking"),
                () -> VERSION,
                (version) -> version.equals(VERSION),
                (version) -> version.equals(VERSION)
        );
        INSTANCE.messageBuilder(PlayerTagCapPack.class, nextID())
                .encoder(PlayerTagCapPack::toBytes)
                .decoder(PlayerTagCapPack::new)
                .consumer(PlayerTagCapPack::handler)
                .add();
        INSTANCE.messageBuilder(FoodStatSyncPack.class, nextID())
                .encoder(FoodStatSyncPack::toBytes)
                .decoder(FoodStatSyncPack::new)
                .consumer(FoodStatSyncPack::handler)
                .add();
        INSTANCE.messageBuilder(FeelingHudDisplayPack.class, nextID())
                .encoder(FeelingHudDisplayPack::toBytes)
                .decoder(FeelingHudDisplayPack::new)
                .consumer(FeelingHudDisplayPack::handler)
                .add();
        INSTANCE.messageBuilder(SoundPack.class, nextID())
                .encoder(SoundPack::toBytes)
                .decoder(SoundPack::new)
                .consumer(SoundPack::handler)
                .add();
    }
}
