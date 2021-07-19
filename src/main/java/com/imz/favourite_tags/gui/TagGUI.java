package com.imz.favourite_tags.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;

public class TagGUI extends Screen implements ICustomButton{


    protected TagGUI(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
    }

    @Override
    protected void init() {
        super.init();

    }

    @Override
    public void render(@Nonnull MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
    }

    @Override
    public void addButton(Button button) {
        super.addButton(button);
    }
}

