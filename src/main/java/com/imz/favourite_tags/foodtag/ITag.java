package com.imz.favourite_tags.foodtag;

import net.minecraft.util.text.ITextComponent;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public interface ITag {
    String getRegistryName();
    ITextComponent getDisplayName();
    void effect();
}
