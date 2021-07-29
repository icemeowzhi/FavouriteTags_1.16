package com.imz.favourite_tags.gui.widget;

import com.imz.favourite_tags.gui.renderer.IRenderable;
import com.imz.favourite_tags.gui.renderer.SimpleTextRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.List;

public class SelectedWindow implements IWidget {

    List<IRenderable> datas = new ArrayList<>();


    @Override
    public void init(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks,int startPosX,int startPosY) {
        for (IRenderable data: datas) {
            data.render(matrixStack,startPosX,startPosY);
        }
    }


    public void refresh(List<IRenderable> datas){
        this.datas = datas;
    }

}
