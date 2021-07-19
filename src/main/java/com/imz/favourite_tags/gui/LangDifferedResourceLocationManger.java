package com.imz.favourite_tags.gui;

import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

/*
实现根据语言分配不同ResourceLocation的功能
 */
public class LangDifferedResourceLocationManger {

    private static final HashMap<String, ResourceLocation> categoryTextureResourceLocation = new HashMap<>();

    //注册时，必须包含默认语言（英语）
    static {
        categoryTextureResourceLocation.put("en_us",new ResourceLocation(""));
    }

    //默认的语言
    public static ResourceLocation getDefaultCategory(){
        return categoryTextureResourceLocation.get("en_us");
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
