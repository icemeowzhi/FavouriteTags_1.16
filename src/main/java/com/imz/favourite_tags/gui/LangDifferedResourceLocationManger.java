package com.imz.favourite_tags.gui;

import com.imz.favourite_tags.util.Constants;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;

/*
实现根据语言分配不同ResourceLocation的功能
 */
// @Mod.EventBusSubscriber(value = Dist.CLIENT)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LangDifferedResourceLocationManger {

    private static HashMap<String, ResourceLocation> categoryTextureResourceLocation;


    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        categoryTextureResourceLocation = new HashMap<>();
        categoryTextureResourceLocation.put("en_us",new ResourceLocation(Constants.MODID,"textures/gui/lang_differed/en_us.png"));
        categoryTextureResourceLocation.put("zh_cn",new ResourceLocation(Constants.MODID,"textures/gui/lang_differed/zh_cn.png"));
    }

    //注册时，必须包含默认语言（英语）
    /*
    static {
        categoryTextureResourceLocation.put("en_us",new ResourceLocation(Constants.MODID,"textures/gui/langDiffered/en_us"));
    }

     */

    //默认的语言
    public static ResourceLocation getDefaultCategory(){
        return new ResourceLocation(Constants.MODID,"textures/gui/lang_differed/en_us.png");
    }

    //通过一个code访问不同的材质
    public static ResourceLocation getCategoryLangDifferedTexture(String langCodeIn){
        if (categoryTextureResourceLocation.get(langCodeIn) != null){
            return categoryTextureResourceLocation.get(langCodeIn);
        }else {
            return getDefaultCategory();
        }
    }

}
