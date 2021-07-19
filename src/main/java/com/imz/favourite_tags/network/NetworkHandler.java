package com.imz.favourite_tags.network;

import com.imz.favourite_tags.Utils.Constants;
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
    }
}
