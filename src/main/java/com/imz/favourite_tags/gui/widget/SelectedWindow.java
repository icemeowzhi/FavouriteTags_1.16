package com.imz.favourite_tags.gui.widget;

import com.imz.favourite_tags.gui.renderer.IRenderable;
import com.mojang.blaze3d.matrix.MatrixStack;

import java.util.ArrayList;
import java.util.List;

public class SelectedWindow implements IWidget {

    List<IRenderable> datas = new ArrayList<>();

    @Override
    public void init(MatrixStack matrixStack) {
        for (IRenderable data: datas) {
            data.render(matrixStack);
        }
    }


    public void refresh(List<IRenderable> datas){
        this.datas = datas;
    }

}
