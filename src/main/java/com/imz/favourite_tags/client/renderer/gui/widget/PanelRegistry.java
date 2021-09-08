package com.imz.favourite_tags.client.renderer.gui.widget;

import com.imz.StateGUI.client.PanelInitializer;
import com.imz.favourite_tags.FavouriteTag;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * @author icemeowzhi
 * @date 2021/9/8
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = FavouriteTag.MODID,value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
public class PanelRegistry {
    @SubscribeEvent()
    public static void onPanelRegister(FMLCommonSetupEvent event){
        PanelInitializer.register(TagPanel.class);
    }
}
