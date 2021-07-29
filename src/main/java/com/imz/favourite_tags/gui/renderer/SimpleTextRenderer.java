package com.imz.favourite_tags.gui.renderer;

import com.imz.favourite_tags.util.Constants;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.ITextComponent;

public class SimpleTextRenderer implements IRenderable{
    Vector2f startPos;
    ITextComponent text;
    boolean center;
    int color;
    int x;
    int y;

    public SimpleTextRenderer(Vector2f startPos, ITextComponent text, boolean center ,int color) {
        this.startPos = startPos;
        x = (int) startPos.x;
        y = (int) startPos.y;
        this.text = text;
        this.center = center;
        this.color = color;
    }

    @Override
    public void render(MatrixStack matrixStack, int startPosX, int startPosY) {

        if (!center) {
            IReorderingProcessor ireorderingprocessor = text.func_241878_f();
            Minecraft.getInstance().fontRenderer.func_238422_b_(matrixStack, ireorderingprocessor, x, y, color);
        }else {
            IReorderingProcessor ireorderingprocessor = text.func_241878_f();
            Minecraft.getInstance().fontRenderer.func_238422_b_(matrixStack, ireorderingprocessor, (float)(x - (Minecraft.getInstance().fontRenderer.func_243245_a(ireorderingprocessor)) / 2), (float)y, color);
        }
        Minecraft.getInstance().getTextureManager().bindTexture(Constants.UI);
    }

    @Override
    public int getRenderEnd() {
        return 0;
    }

    @Override
    public Vector2f getStartPos() {
        return startPos;
    }
}
