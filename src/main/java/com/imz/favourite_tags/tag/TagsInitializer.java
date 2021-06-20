package com.imz.favourite_tags.tag;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Random;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class TagsInitializer {
    public static ITags createPlayerTags(EnumTagGroup group){ // use to create a group of player tags
        ArrayList<ITag> allTags = TagInitializer.getAllTag();
        Random random = new Random();
        ArrayList<ITag> tagInGroup = new ArrayList<>();
        for(ITag tag : allTags){
            if (tag.getGroup() == group){
                tagInGroup.add(tag);
            }
        }

        if (group == EnumTagGroup.FOODS_LIKE){
            ITags tags = new FoodTags(EnumTagGroup.FOODS_LIKE);
            /*
            int common = random.nextInt(4);
            int uncommon = random.nextInt(4);
            int rare = random.nextInt(3);
            int epic = random.nextInt(2);

             */

            int common = random.nextInt(1);
            int uncommon = random.nextInt(1);
            int rare = random.nextInt(1);
            int epic = random.nextInt(1);

            for (int i=0;i<common;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size()+1)).withRarity(EnumTagRarity.COMMON));
            }
            for (int i=0;i<uncommon;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size()+1)).withRarity(EnumTagRarity.UNCOMMON));
            }
            for (int i=0;i<rare;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size()+1)).withRarity(EnumTagRarity.RARE));
            }
            for (int i=0;i<epic;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size()+1)).withRarity(EnumTagRarity.EPIC));
            }
            return tags;
        }else if (group == EnumTagGroup.FOODS_DISLIKE){
            ITags tags = new FoodTags(EnumTagGroup.FOODS_DISLIKE);
            //int count = random.nextInt(7);
            int count = random.nextInt(1);
            for (int i=0;i<count;i++){
                tags.addTag(tagInGroup.remove(random.nextInt(tagInGroup.size()+1)).withRarity(EnumTagRarity.COMMON));
            }
            return tags;
        }
        return null;
    }

    public static ITags createItemTags(ItemStack itemStack){ // use EnumTagGroup.FOODS_LIKE as group,otherwise it won't effect.
        ArrayList<ITag> tags = FoodTagInitializer.tagMap.get(itemStack.getItem());
        if (tags == null)
            return null;
        return new FoodTags(EnumTagGroup.FOODS_LIKE,tags);
    }
}
