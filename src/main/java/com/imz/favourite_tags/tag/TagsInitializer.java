package com.imz.favourite_tags.tag;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TagsInitializer {
    public static ITags createPlayerTags(EnumTagGroup group, @Nullable ArrayList<ITag> ignoreTag){ // use to create a group of player tags
        ArrayList<ITag> allTags = (ArrayList<ITag>) TagInitializer.getAllTag().clone();
        Random random = new Random();
        ArrayList<ITag> tagInGroup = new ArrayList<>();

        if (ignoreTag != null){
            for (ITag tag:ignoreTag){
                allTags.remove(tag);
            }
        }

        for(ITag tag : allTags){
            if (tag.getGroup() == group || tag.getGroup() == EnumTagGroup.FOODS_BOTH){
                tagInGroup.add(tag);
            }
        }

        if (group == EnumTagGroup.FOODS_LIKE){
            ITags tags = new FoodTags(EnumTagGroup.FOODS_LIKE);

            int common = random.nextInt(4);
            int uncommon = random.nextInt(4);
            int rare = random.nextInt(3);
            int epic = random.nextInt(2);

            /*
            int common = random.nextInt(3);
            int uncommon = random.nextInt(2);
            int rare = random.nextInt(2);
            int epic = random.nextInt(2);

             */
            //tags.addTag(TagInitializer.apple.withRarity(EnumTagRarity.EPIC));//test code

            for (int i=0;i<common;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size())).withRarity(EnumTagRarity.COMMON));
                //System.out.println(tagInGroup.size());
                //TODO:修复进地狱的问题
            }
            for (int i=0;i<uncommon;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size())).withRarity(EnumTagRarity.UNCOMMON));
                //System.out.println(tagInGroup.size());
            }
            for (int i=0;i<rare;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size())).withRarity(EnumTagRarity.RARE));
                //System.out.println(tagInGroup.size());
            }
            for (int i=0;i<epic;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size())).withRarity(EnumTagRarity.EPIC));
                //System.out.println(tagInGroup.size());
            }
            return tags;
        }

        if (group == EnumTagGroup.FOODS_DISLIKE){
            ITags tags = new FoodTags(EnumTagGroup.FOODS_DISLIKE);
            //int count = random.nextInt(7);
            int count = random.nextInt(4);
            for (int i=0;i<count;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size())).withRarity(EnumTagRarity.COMMON));
            }
            return tags;
        }
        return new FoodTags(EnumTagGroup.NONE);
    }

    public static ITags createItemTags(ItemStack itemStack){ // use EnumTagGroup.FOOD_ITEM_TAG as group,otherwise it won't effect.
        ArrayList<ITag> tags = new ArrayList<>(Arrays.asList(FoodTagInitializer.tagMap.get(itemStack.getItem())));
        return new FoodTags(EnumTagGroup.FOOD_ITEM_TAG,tags);
    }
}
