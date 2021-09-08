package com.imz.StateGUI.client;

import com.imz.StateGUI.ModStateGUI;
import com.imz.StateGUI.client.gui.widget.StatePanel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/9/8
 * @apiNote
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT,modid = ModStateGUI.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class PanelInitializer {
    private static List<Class<? extends StatePanel>> panelClassList;

    public static List<Class<? extends StatePanel>> getPanelClassList() {
        return panelClassList;
    }

    public static void register(Class<? extends StatePanel> panelClass){
        if (panelClassList == null){
            panelClassList = new ArrayList<>();}
        panelClassList.add(panelClass);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onPanelRegister(FMLCommonSetupEvent event){
        panelClassList = new ArrayList<>();
    }
}
