package com.imz.favourite_tags.network;

import com.imz.favourite_tags.FavouriteTag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,modid = FavouriteTag.MODID)
public class NetworkHandler {
    public static SimpleChannel INSTANCE;
    public static final String VERSION = "1.0";
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerPack() {
        INSTANCE = NetworkRegistry.newSimpleChannel(
                new ResourceLocation(FavouriteTag.MODID, "favourite_tag_networking"),
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
        INSTANCE.messageBuilder(PlayerFedUpPack.class, nextID())
                .encoder(PlayerFedUpPack::toBytes)
                .decoder(PlayerFedUpPack::new)
                .consumer(PlayerFedUpPack::handler)
                .add();
        INSTANCE.messageBuilder(SoundPack.class, nextID())
                .encoder(SoundPack::toBytes)
                .decoder(SoundPack::new)
                .consumer(SoundPack::handler)
                .add();
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkHandler::registerPack);
    }
}