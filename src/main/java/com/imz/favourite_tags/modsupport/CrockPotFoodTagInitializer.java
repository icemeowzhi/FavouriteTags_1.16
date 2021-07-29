package com.imz.favourite_tags.modsupport;

import com.imz.favourite_tags.tag.FoodTagInitializer;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.TagInitializer;
import com.sihenzhang.crockpot.CrockPotRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CrockPotFoodTagInitializer {

    @SubscribeEvent
    public static void registerFoodTag(FMLCommonSetupEvent event){

        if (!ModList.get().isLoaded("crockpot")){
            return;
        }

        FoodTagInitializer.register(CrockPotRegistry.cookedEgg,new ITag[]{TagInitializer.fried,TagInitializer.egg});
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

    }

}
