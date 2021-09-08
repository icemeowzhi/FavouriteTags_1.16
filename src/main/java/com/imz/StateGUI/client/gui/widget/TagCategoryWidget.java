package com.imz.StateGUI.client.gui.widget;

import com.imz.StateGUI.ModStateGUI;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.IBidiTooltip;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author icemeowzhi
 * @date 2021/9/7
 * @apiNote
 */
public class TagCategoryWidget extends Widget implements IBidiTooltip {
    ITextComponent displayText;
    List<IReorderingProcessor> tooltips;
    Screen parent;
    boolean renderTooltip;
    final ResourceLocation widgetTexture = new ResourceLocation(ModStateGUI.MODID, "textures/gui/stategui_widget.png");

    public TagCategoryWidget(int x, int y, ITextComponent title, Screen parent, ITextComponent displayText, List<IReorderingProcessor> tooltips) {
        super(x, y, 161, 15, title);
        this.displayText = displayText;
        this.tooltips = tooltips;
        this.parent = parent;
        renderTooltip = true;
    }

    public TagCategoryWidget(int x, int y, ITextComponent title, Screen parent, ITextComponent displayText) {
        super(x, y, 161, 15, title);
        this.displayText = displayText;
        this.tooltips = new ArrayList<>();
        this.parent = parent;
        renderTooltip = false;
    }

    public void setPosition(int xIn, int yIn) {
        this.x = xIn;
        this.y = yIn;
    }

    @Nonnull
    @Override
    public Optional<List<IReorderingProcessor>> func_241867_d() {
        return Optional.of(tooltips);
    }

    @Override
    public void renderToolTip(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.renderToolTip(matrixStack, mouseX, mouseY);
        if (renderTooltip){
            func_241867_d().ifPresent((tooltip)->{
                parent.renderToolTip(matrixStack,tooltip, mouseX,mouseY,parent.getMinecraft().fontRenderer);
            });
        }
    }

    @Override
    public void renderWidget(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {

        this.parent.getMinecraft().getTextureManager().bindTexture(widgetTexture);
        //边框
        parent.blit(matrixStack,x,y,0,96,width,height);
        //文字
        Style style = displayText.getStyle().setBold(true);
        parent.getMinecraft().fontRenderer.drawText(matrixStack, displayText.copyRaw().setStyle(style), this.x + 4, this.y + (this.height - 6) / 2, 0xff474657);

    }
}
