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
public class CrockPotFoodTagInitializer {
    public static final String MODID = "crockpot";

    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event){

        if (!ModList.get().isLoaded(MODID)){
            return;
        }

        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_egg")),new FoodTag[]{TagInitializer.fried,TagInitializer.egg});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"frog_legs")),new FoodTag[]{TagInitializer.raw,TagInitializer.frog,TagInitializer.meat});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_frog_legs")),new FoodTag[]{TagInitializer.fried,TagInitializer.frog,TagInitializer.meat});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"milk_bottle")),new FoodTag[]{TagInitializer.milk});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"syrup")),new FoodTag[]{TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"asparagus_soup")),new FoodTag[]{TagInitializer.soup,TagInitializer.asparagus,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"avaj")),new FoodTag[]{TagInitializer.coffee,TagInitializer.hot_drink,TagInitializer.golden});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"bacon_eggs")),new FoodTag[]{TagInitializer.bacon,TagInitializer.egg,TagInitializer.meat,TagInitializer.smoked});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"bone_soup")),new FoodTag[]{TagInitializer.soup,TagInitializer.onion});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"bone_stew")),new FoodTag[]{TagInitializer.soup,TagInitializer.meat});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"california_roll")),new FoodTag[]{TagInitializer.fish,TagInitializer.kelp});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"candy")),new FoodTag[]{TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"ceviche")),new FoodTag[]{TagInitializer.fish,TagInitializer.cold});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"fish_sticks")),new FoodTag[]{TagInitializer.fried,TagInitializer.fish});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"fish_tacos")),new FoodTag[]{TagInitializer.fish,TagInitializer.fried,TagInitializer.cereal});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"flower_salad")),new FoodTag[]{TagInitializer.vegetable,TagInitializer.salad});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"froggle_bunwich")),new FoodTag[]{TagInitializer.fried,TagInitializer.frog,TagInitializer.meat,TagInitializer.cereal,TagInitializer.carbohydrate});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"fruit_medley")),new FoodTag[]{TagInitializer.fruit});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"gazpacho")),new FoodTag[]{TagInitializer.soup,TagInitializer.cold,TagInitializer.asparagus});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"honey_ham")),new FoodTag[]{TagInitializer.sweet,TagInitializer.honey,TagInitializer.meat,TagInitializer.smoked});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"honey_nuggets")),new FoodTag[]{TagInitializer.sweet,TagInitializer.honey,TagInitializer.meat});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"hot_chili")),new FoodTag[]{TagInitializer.spicy,TagInitializer.meat,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"hot_cocoa")),new FoodTag[]{TagInitializer.cocoa,TagInitializer.milk,TagInitializer.sweet,TagInitializer.hot_drink});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"ice_cream")),new FoodTag[]{TagInitializer.cold,TagInitializer.milk,TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"iced_tea")),new FoodTag[]{TagInitializer.cold,TagInitializer.tea,TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"jammy_preserves")),new FoodTag[]{TagInitializer.fruit,TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"kabobs")),new FoodTag[]{TagInitializer.meat,TagInitializer.fried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"meat_balls")),new FoodTag[]{TagInitializer.meat,TagInitializer.fried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"monster_lasagna")),new FoodTag[]{TagInitializer.monster,TagInitializer.cereal,TagInitializer.carbohydrate});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"monster_tartare")),new FoodTag[]{TagInitializer.monster,TagInitializer.egg,TagInitializer.processed_raw});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"moqueca")),new FoodTag[]{TagInitializer.fish,TagInitializer.onion,TagInitializer.tomato});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"mushy_cake")),new FoodTag[]{TagInitializer.mushroom,TagInitializer.cake,TagInitializer.baked});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pepper_popper")),new FoodTag[]{TagInitializer.chili,TagInitializer.spicy,TagInitializer.meat,TagInitializer.fried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"perogies")),new FoodTag[]{TagInitializer.meat,TagInitializer.egg,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"potato_souffle")),new FoodTag[]{TagInitializer.potato,TagInitializer.egg,TagInitializer.baked});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"potato_tornado")),new FoodTag[]{TagInitializer.potato,TagInitializer.fried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pow_cake")),new FoodTag[]{TagInitializer.cereal,TagInitializer.honey,TagInitializer.baked});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pumpkin_cookie")),new FoodTag[]{TagInitializer.pumpkin,TagInitializer.honey,TagInitializer.sweet});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"ratatouille")),new FoodTag[]{TagInitializer.vegetable,TagInitializer.sauce});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"salsa")),new FoodTag[]{TagInitializer.sauce,TagInitializer.tomato,TagInitializer.onion});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"seafood_gumbo")),new FoodTag[]{TagInitializer.fish,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"stuffed_eggplant")),new FoodTag[]{TagInitializer.eggplant,TagInitializer.meat,TagInitializer.fried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"surf_n_turf")),new FoodTag[]{TagInitializer.meat,TagInitializer.fish,TagInitializer.fried});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"taffy")),new FoodTag[]{TagInitializer.sweet,TagInitializer.honey});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"tea")),new FoodTag[]{TagInitializer.hot_drink,TagInitializer.tea});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"tropical_bouillabaisse")),new FoodTag[]{TagInitializer.fish,TagInitializer.vegetable,TagInitializer.soup});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"turkey_dinner")),new FoodTag[]{TagInitializer.baked,TagInitializer.chicken,TagInitializer.meat});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"veg_stinger")),new FoodTag[]{TagInitializer.cold,TagInitializer.vegetable,TagInitializer.wine});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"watermelon_icle")),new FoodTag[]{TagInitializer.fruit,TagInitializer.watermelon,TagInitializer.cold});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"asparagus")),new FoodTag[]{TagInitializer.vegetable,TagInitializer.asparagus});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"corn")),new FoodTag[]{TagInitializer.cereal,TagInitializer.raw});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"popcorn")),new FoodTag[]{TagInitializer.cereal,TagInitializer.carbohydrate,TagInitializer.baked});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"eggplant")),new FoodTag[]{TagInitializer.eggplant,TagInitializer.raw,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_eggplant")),new FoodTag[]{TagInitializer.eggplant,TagInitializer.fried,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"onion")),new FoodTag[]{TagInitializer.onion,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pepper")),new FoodTag[]{TagInitializer.chili,TagInitializer.vegetable});
        TaggedFoodInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"tomato")),new FoodTag[]{TagInitializer.tomato,TagInitializer.vegetable});


    }

}
