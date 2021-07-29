package com.imz.favourite_tags.gui.vanilla;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class VanillaInject {


    @SubscribeEvent
    public static void onGuiPostInit(GuiScreenEvent.InitGuiEvent.Post event) {
        Screen screen = event.getGui();
        if (screen instanceof InventoryScreen) {
            InventoryScreen inventoryScreen = (InventoryScreen) screen;
            if (event.getWidgetList() != null) {
                event.addWidget(new ShowTagGuiButton(inventoryScreen));
            }
        }
    }

}
