package com.imz.favourite_tags.gui.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.util.math.vector.Vector2f;

/*
可进行渲染的接口，用于SelectWindow渲染各种数据
在render()中写关于某种数据渲染的代码。
 */
public interface IRenderable {
    void render(MatrixStack matrixStack);

    //得到从渲染点到下一个渲染点的大小，便于多次渲染。
    int getRenderEnd();

    //得到开始渲染的坐标
    Vector2f getStartPos();
}
