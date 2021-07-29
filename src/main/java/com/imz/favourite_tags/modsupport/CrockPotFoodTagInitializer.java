package com.imz.favourite_tags.modsupport;

import com.imz.favourite_tags.tag.FoodTagInitializer;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.TagInitializer;
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

        if (!ModList.get().isLoaded("crockpot")){
            return;
        }

        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_egg")),new ITag[]{TagInitializer.fried,TagInitializer.egg});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"frog_legs")),new ITag[]{TagInitializer.raw,TagInitializer.frog,TagInitializer.meat});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_frog_legs")),new ITag[]{TagInitializer.fried,TagInitializer.frog,TagInitializer.meat});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"milk_bottle")),new ITag[]{TagInitializer.milk});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"syrup")),new ITag[]{TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"asparagus_soup")),new ITag[]{TagInitializer.soup,TagInitializer.asparagus,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"avaj")),new ITag[]{TagInitializer.coffee,TagInitializer.hot_drink,TagInitializer.golden});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"bacon_eggs")),new ITag[]{TagInitializer.bacon,TagInitializer.egg,TagInitializer.meat,TagInitializer.smoked});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"bone_soup")),new ITag[]{TagInitializer.soup,TagInitializer.onion});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"bone_stew")),new ITag[]{TagInitializer.soup,TagInitializer.meat});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"california_roll")),new ITag[]{TagInitializer.fish,TagInitializer.kelp});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"candy")),new ITag[]{TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"ceviche")),new ITag[]{TagInitializer.fish,TagInitializer.cold});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"fish_sticks")),new ITag[]{TagInitializer.fried,TagInitializer.fish});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"fish_tacos")),new ITag[]{TagInitializer.fish,TagInitializer.fried,TagInitializer.cereal});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"flower_salad")),new ITag[]{TagInitializer.vegetable,TagInitializer.salad});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"froggle_bunwich")),new ITag[]{TagInitializer.fried,TagInitializer.frog,TagInitializer.meat,TagInitializer.cereal,TagInitializer.carbohydrate});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"fruit_medley")),new ITag[]{TagInitializer.fruit});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"gazpacho")),new ITag[]{TagInitializer.soup,TagInitializer.cold,TagInitializer.asparagus});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"honey_ham")),new ITag[]{TagInitializer.sweet,TagInitializer.honey,TagInitializer.meat,TagInitializer.smoked});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"honey_nuggets")),new ITag[]{TagInitializer.sweet,TagInitializer.honey,TagInitializer.meat});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"hot_chili")),new ITag[]{TagInitializer.spicy,TagInitializer.meat,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"hot_cocoa")),new ITag[]{TagInitializer.cocoa,TagInitializer.milk,TagInitializer.sweet,TagInitializer.hot_drink});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"ice_cream")),new ITag[]{TagInitializer.cold,TagInitializer.milk,TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"iced_tea")),new ITag[]{TagInitializer.cold,TagInitializer.tea,TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"jammy_preserves")),new ITag[]{TagInitializer.fruit,TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"kabobs")),new ITag[]{TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"meat_balls")),new ITag[]{TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"monster_lasagna")),new ITag[]{TagInitializer.monster,TagInitializer.cereal,TagInitializer.carbohydrate});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"monster_tartare")),new ITag[]{TagInitializer.monster,TagInitializer.egg,TagInitializer.processed_raw});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"moqueca")),new ITag[]{TagInitializer.fish,TagInitializer.onion,TagInitializer.tomato});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"mushy_cake")),new ITag[]{TagInitializer.mushroom,TagInitializer.cake,TagInitializer.baked});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pepper_popper")),new ITag[]{TagInitializer.chili,TagInitializer.spicy,TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"perogies")),new ITag[]{TagInitializer.meat,TagInitializer.egg,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"potato_souffle")),new ITag[]{TagInitializer.potato,TagInitializer.egg,TagInitializer.baked});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"potato_tornado")),new ITag[]{TagInitializer.potato,TagInitializer.fried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pow_cake")),new ITag[]{TagInitializer.cereal,TagInitializer.honey,TagInitializer.baked});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pumpkin_cookie")),new ITag[]{TagInitializer.pumpkin,TagInitializer.honey,TagInitializer.sweet});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"ratatouille")),new ITag[]{TagInitializer.vegetable,TagInitializer.sauce});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"salsa")),new ITag[]{TagInitializer.sauce,TagInitializer.tomato,TagInitializer.onion});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"seafood_gumbo")),new ITag[]{TagInitializer.fish,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"stuffed_eggplant")),new ITag[]{TagInitializer.eggplant,TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"surf_n_turf")),new ITag[]{TagInitializer.meat,TagInitializer.fish,TagInitializer.fried});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"taffy")),new ITag[]{TagInitializer.sweet,TagInitializer.honey});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"tea")),new ITag[]{TagInitializer.hot_drink,TagInitializer.tea});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"tropical_bouillabaisse")),new ITag[]{TagInitializer.fish,TagInitializer.vegetable,TagInitializer.soup});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"turkey_dinner")),new ITag[]{TagInitializer.baked,TagInitializer.chicken,TagInitializer.meat});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"veg_stinger")),new ITag[]{TagInitializer.cold,TagInitializer.vegetable,TagInitializer.wine});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"watermelon_icle")),new ITag[]{TagInitializer.fruit,TagInitializer.watermelon,TagInitializer.cold});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"asparagus")),new ITag[]{TagInitializer.vegetable,TagInitializer.asparagus});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"corn")),new ITag[]{TagInitializer.cereal,TagInitializer.raw});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"popcorn")),new ITag[]{TagInitializer.cereal,TagInitializer.carbohydrate,TagInitializer.baked});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"eggplant")),new ITag[]{TagInitializer.eggplant,TagInitializer.raw,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"cooked_eggplant")),new ITag[]{TagInitializer.eggplant,TagInitializer.fried,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"onion")),new ITag[]{TagInitializer.onion,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"pepper")),new ITag[]{TagInitializer.chili,TagInitializer.vegetable});
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"tomato")),new ITag[]{TagInitializer.tomato,TagInitializer.vegetable});

        /*
        FoodTagInitializer.register(ForgeRegistries.ITEMS.getValue(new ResourceLocation(MODID,"")),new ITag[]{TagInitializer.fried,TagInitializer.egg});
        FoodTagInitializer.register(CrockPotRegistry.frogLegs,new ITag[]{TagInitializer.raw,TagInitializer.frog,TagInitializer.meat});
        FoodTagInitializer.register(CrockPotRegistry.cookedFrogLegs,new ITag[]{TagInitializer.fried,TagInitializer.frog,TagInitializer.meat});
        FoodTagInitializer.register(CrockPotRegistry.milkBottle,new ITag[]{TagInitializer.milk});
        FoodTagInitializer.register(CrockPotRegistry.syrup,new ITag[]{TagInitializer.sweet});
        FoodTagInitializer.register(CrockPotRegistry.asparagusSoup,new ITag[]{TagInitializer.soup,TagInitializer.asparagus,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.avaj,new ITag[]{TagInitializer.coffee,TagInitializer.hot_drink,TagInitializer.golden});
        FoodTagInitializer.register(CrockPotRegistry.baconEggs,new ITag[]{TagInitializer.bacon,TagInitializer.egg,TagInitializer.meat,TagInitializer.smoked});
        FoodTagInitializer.register(CrockPotRegistry.boneSoup,new ITag[]{TagInitializer.soup,TagInitializer.onion});
        FoodTagInitializer.register(CrockPotRegistry.boneStew,new ITag[]{TagInitializer.soup,TagInitializer.meat});
        FoodTagInitializer.register(CrockPotRegistry.californiaRoll,new ITag[]{TagInitializer.fish,TagInitializer.kelp});
        FoodTagInitializer.register(CrockPotRegistry.candy,new ITag[]{TagInitializer.sweet});
        FoodTagInitializer.register(CrockPotRegistry.ceviche,new ITag[]{TagInitializer.fish,TagInitializer.cold});
        FoodTagInitializer.register(CrockPotRegistry.fishSticks,new ITag[]{TagInitializer.fried,TagInitializer.fish});
        FoodTagInitializer.register(CrockPotRegistry.fishTacos,new ITag[]{TagInitializer.fish,TagInitializer.fried,TagInitializer.cereal});
        FoodTagInitializer.register(CrockPotRegistry.flowerSalad,new ITag[]{TagInitializer.vegetable,TagInitializer.salad});
        FoodTagInitializer.register(CrockPotRegistry.froggleBunwich,new ITag[]{TagInitializer.fried,TagInitializer.frog,TagInitializer.meat,TagInitializer.cereal,TagInitializer.carbohydrate});
        FoodTagInitializer.register(CrockPotRegistry.fruitMedley,new ITag[]{TagInitializer.fruit});
        FoodTagInitializer.register(CrockPotRegistry.gazpacho,new ITag[]{TagInitializer.soup,TagInitializer.cold,TagInitializer.asparagus});
        FoodTagInitializer.register(CrockPotRegistry.honeyHam,new ITag[]{TagInitializer.sweet,TagInitializer.honey,TagInitializer.meat,TagInitializer.smoked});
        FoodTagInitializer.register(CrockPotRegistry.honeyNuggets,new ITag[]{TagInitializer.sweet,TagInitializer.honey,TagInitializer.meat});
        FoodTagInitializer.register(CrockPotRegistry.hotChili,new ITag[]{TagInitializer.spicy,TagInitializer.meat,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.hotCocoa,new ITag[]{TagInitializer.cocoa,TagInitializer.milk,TagInitializer.sweet,TagInitializer.hot_drink});
        FoodTagInitializer.register(CrockPotRegistry.iceCream,new ITag[]{TagInitializer.cold,TagInitializer.milk,TagInitializer.sweet});
        FoodTagInitializer.register(CrockPotRegistry.icedTea,new ITag[]{TagInitializer.cold,TagInitializer.tea,TagInitializer.sweet});
        FoodTagInitializer.register(CrockPotRegistry.jammyPreserves,new ITag[]{TagInitializer.fruit,TagInitializer.sweet});
        FoodTagInitializer.register(CrockPotRegistry.kabobs,new ITag[]{TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(CrockPotRegistry.meatBalls,new ITag[]{TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(CrockPotRegistry.monsterLasagna,new ITag[]{TagInitializer.monster,TagInitializer.cereal,TagInitializer.carbohydrate});
        FoodTagInitializer.register(CrockPotRegistry.monsterTartare,new ITag[]{TagInitializer.monster,TagInitializer.egg,TagInitializer.processed_raw});
        FoodTagInitializer.register(CrockPotRegistry.moqueca,new ITag[]{TagInitializer.fish,TagInitializer.onion,TagInitializer.tomato});
        FoodTagInitializer.register(CrockPotRegistry.mushyCake,new ITag[]{TagInitializer.mushroom,TagInitializer.cake,TagInitializer.baked});
        FoodTagInitializer.register(CrockPotRegistry.pepperPopper,new ITag[]{TagInitializer.chili,TagInitializer.spicy,TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(CrockPotRegistry.perogies,new ITag[]{TagInitializer.meat,TagInitializer.egg,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.potatoSouffle,new ITag[]{TagInitializer.potato,TagInitializer.egg,TagInitializer.baked});
        FoodTagInitializer.register(CrockPotRegistry.potatoTornado,new ITag[]{TagInitializer.potato,TagInitializer.fried});
        FoodTagInitializer.register(CrockPotRegistry.powCake,new ITag[]{TagInitializer.cereal,TagInitializer.honey,TagInitializer.baked});
        FoodTagInitializer.register(CrockPotRegistry.pumpkinCookie,new ITag[]{TagInitializer.pumpkin,TagInitializer.honey,TagInitializer.sweet});
        FoodTagInitializer.register(CrockPotRegistry.ratatouille,new ITag[]{TagInitializer.vegetable,TagInitializer.sauce});
        FoodTagInitializer.register(CrockPotRegistry.salsa,new ITag[]{TagInitializer.sauce,TagInitializer.tomato,TagInitializer.onion});
        FoodTagInitializer.register(CrockPotRegistry.seafoodGumbo,new ITag[]{TagInitializer.fish,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.stuffedEggplant,new ITag[]{TagInitializer.eggplant,TagInitializer.meat,TagInitializer.fried});
        FoodTagInitializer.register(CrockPotRegistry.surfNTurf,new ITag[]{TagInitializer.meat,TagInitializer.fish,TagInitializer.fried});
        FoodTagInitializer.register(CrockPotRegistry.taffy,new ITag[]{TagInitializer.sweet,TagInitializer.honey});
        FoodTagInitializer.register(CrockPotRegistry.tea,new ITag[]{TagInitializer.hot_drink,TagInitializer.tea});
        FoodTagInitializer.register(CrockPotRegistry.tropicalBouillabaisse,new ITag[]{TagInitializer.fish,TagInitializer.vegetable,TagInitializer.soup});
        FoodTagInitializer.register(CrockPotRegistry.turkeyDinner,new ITag[]{TagInitializer.baked,TagInitializer.chicken,TagInitializer.meat});
        FoodTagInitializer.register(CrockPotRegistry.vegStinger,new ITag[]{TagInitializer.cold,TagInitializer.vegetable,TagInitializer.wine});
        FoodTagInitializer.register(CrockPotRegistry.watermelonIcle,new ITag[]{TagInitializer.fruit,TagInitializer.watermelon,TagInitializer.cold});
        FoodTagInitializer.register(CrockPotRegistry.asparagus,new ITag[]{TagInitializer.vegetable,TagInitializer.asparagus});
        FoodTagInitializer.register(CrockPotRegistry.corn,new ITag[]{TagInitializer.cereal,TagInitializer.raw});
        FoodTagInitializer.register(CrockPotRegistry.popcorn,new ITag[]{TagInitializer.cereal,TagInitializer.carbohydrate,TagInitializer.baked});
        FoodTagInitializer.register(CrockPotRegistry.eggplant,new ITag[]{TagInitializer.eggplant,TagInitializer.raw,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.cookedEggplant,new ITag[]{TagInitializer.eggplant,TagInitializer.fried,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.onion,new ITag[]{TagInitializer.onion,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.pepper,new ITag[]{TagInitializer.chili,TagInitializer.vegetable});
        FoodTagInitializer.register(CrockPotRegistry.tomato,new ITag[]{TagInitializer.tomato,TagInitializer.vegetable});
         */

    }

}
