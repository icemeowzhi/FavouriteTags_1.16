package com.imz.StateGUI;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

/**
 * @author icemeowzhi
 * @date 2021/9/1
 * @apiNote
 */
@Mod("state_gui")
public class ModStateGUI {
    public static final String MODID = "state_gui";
    public ModStateGUI(){
        MinecraftForge.EVENT_BUS.register(this);
    }
}
