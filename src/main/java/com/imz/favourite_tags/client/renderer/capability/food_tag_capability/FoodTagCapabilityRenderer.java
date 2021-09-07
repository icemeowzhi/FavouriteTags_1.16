package com.imz.favourite_tags.client.renderer.capability.food_tag_capability;

import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.util.Const;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/9/6
 * @apiNote
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT,modid = FavouriteTag.MODID)
public class FoodTagCapabilityRenderer {
    @SubscribeEvent
    public static void renderTooltip(RenderTooltipEvent.Color event) {
        ItemStack itemStack = event.getStack();
        if (itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).isPresent()) {
            itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).ifPresent((cap) -> {
                event.setBackground(0xf08785a2);
                event.setBorderEnd(0xc8ffe2e2);
                event.setBorderStart(0xffffe2e2);
            });
        }
    }

    @SubscribeEvent
    public static void addTooltip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();
        if (itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).isPresent()){
            itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).ifPresent((cap)->{

                List<FoodTag> foodTags =  cap.getFoodTags();
                event.getToolTip().add(new TranslationTextComponent("tag.tag_contains"));
                for (FoodTag tag : foodTags){
                    TranslationTextComponent tooltipLine = (TranslationTextComponent) tag.getDisplayName();
                    Style style = tooltipLine.getStyle().setColor(Color.fromInt(0x00ffe2e2)).setBold(true);
                    event.getToolTip().add(Const.TAG_PREFIX.copyRaw().appendSibling(tooltipLine).setStyle(style));
                }
            });
        }
    }
}
