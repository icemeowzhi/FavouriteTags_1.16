package com.imz.favourite_tags.capability;


import com.imz.favourite_tags.util.Constants;
import com.imz.favourite_tags.tag.FoodTags;
import com.imz.favourite_tags.tag.ITag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class FoodTagCapabilityRender {
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

                FoodTags foodTags =  cap.getTags();
                event.getToolTip().add(new TranslationTextComponent("tag.tag_contains"));
                for (ITag tag : foodTags.getAllTags()){
                    TranslationTextComponent tooltipLine = tag.getDisplayName();
                    Style style = tooltipLine.getStyle().setColor(Color.fromInt(0x00ffe2e2)).setBold(true);
                    event.getToolTip().add(Constants.TAG_PREFIX.copyRaw().appendSibling(tooltipLine).setStyle(style));
                }
            });
        }
    }

}
