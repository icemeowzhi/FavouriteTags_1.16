package com.imz.favourite_tags.modsupport;


import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.intance.TagInitializer;
import com.imz.favourite_tags.intance.TaggedFoodInitializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ElixirFoodTagInitializer {
    public static final String MODID = "the_elixir";

    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event) {

        if (!ModList.get().isLoaded(MODID)) {
            return;
        }

        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"mango_food")),new FoodTag[]{TagInitializer.fruit});

    }
}
