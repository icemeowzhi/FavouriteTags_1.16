package com.imz.StateGUI.client.gui;

import com.google.common.collect.Lists;
import com.imz.StateGUI.ModStateGUI;
import com.imz.StateGUI.client.gui.widget.StatusPanel;
import com.imz.StateGUI.client.gui.widget.TagWidget;
import com.imz.favourite_tags.foodtag.EnumRarity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/8/2
 * @apiNote
 */
//管理一个BtnList和其对panel的控制
public class StateGUI extends Screen {

    protected StateGUI(ITextComponent titleIn) {
        super(titleIn);
    }

    public final ResourceLocation bg = new ResourceLocation(ModStateGUI.MODID, "textures/gui/stategui_background.png");
    public final int GUI_WIDTH = 332;
    public final int GUI_HEIGHT = 249;
    public int guiLeft = (this.width - GUI_WIDTH) / 2;
    public int guiTop = (this.height - GUI_HEIGHT) / 2;

    private List<Button> tabList = Lists.newArrayList();

    private StatusPanel panel;
    private TagWidget testWidget;
    //TODO:new GUI

    @Override
    public void init(Minecraft minecraft, int width, int height) {
        super.init(minecraft, width, height);

        guiLeft = (this.width - GUI_WIDTH) / 2;
        guiTop = (this.height - GUI_HEIGHT) / 2;

        panel = new StatusPanel(this.minecraft,this) {
            @Override
            public int getContentHeight()
            {
                int height = 50;
                height += (lines.size() * font.FONT_HEIGHT);
                if (height < this.bottom - this.top - 8)
                    height = this.bottom - this.top - 8;
                return height;
            }

            @Override
            protected void drawPanel(MatrixStack mStack, int entryRight, int relativeY, Tessellator tess, int mouseX, int mouseY) {
                for (IReorderingProcessor line : this.lines)
                {
                    if (line != null)
                    {
                        RenderSystem.enableBlend();
                        StateGUI.this.font.drawTextWithShadow(mStack, line, left, relativeY, 0xFFFFFF);
                        RenderSystem.disableAlphaTest();
                        RenderSystem.disableBlend();
                    }
                    relativeY += font.FONT_HEIGHT;
                }
            }
        };

        this.children.add(panel);

        List<IReorderingProcessor> tooltips = Lists.newArrayList(new StringTextComponent("test1").func_241878_f(),new StringTextComponent("test2").func_241878_f());
        testWidget = new TagWidget(guiLeft,guiTop,new StringTextComponent("test"),this, EnumRarity.RARE,tooltips);
        this.children.add(testWidget);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        guiLeft = (this.width - GUI_WIDTH) / 2;
        guiTop = (this.height - GUI_HEIGHT) / 2;
        renderBackground(matrixStack);
        if (panel!=null){
            panel.render(matrixStack,mouseX,mouseY,partialTicks);
        }

        testWidget.render(matrixStack,mouseX,mouseY,partialTicks);
    }

    @Override
    public void renderBackground(MatrixStack matrixStack) {
        super.renderBackground(matrixStack);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(bg);
        blit(matrixStack,guiLeft,guiTop,0,0,332,249,332,249);
    }

    public static class OpenGUI{
        public OpenGUI(){ Minecraft.getInstance().displayGuiScreen(new StateGUI(new TranslationTextComponent(ModStateGUI.MODID + ".statusgui")));}
    }
}
