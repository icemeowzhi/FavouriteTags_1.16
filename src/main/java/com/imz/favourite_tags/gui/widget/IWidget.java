package com.imz.favourite_tags.gui.widget;

import com.mojang.blaze3d.matrix.MatrixStack;

/*
Widget 的功能：
    受一个widget列表的统一管理
    通过在init()里添加代码来在一个gui中添加该组件
 */
public interface IWidget {
    void init(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks,int startPosX,int startPosY);
}
