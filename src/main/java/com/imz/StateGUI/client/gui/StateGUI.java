package com.imz.StateGUI.client.gui;

import com.imz.StateGUI.ModStateGUI;
import com.imz.StateGUI.client.gui.widget.StateButton;
import com.imz.StateGUI.client.gui.widget.StatePanel;
import com.imz.favourite_tags.client.renderer.gui.widget.TagPanel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/8/2
 * @apiNote
 */
//管理一个BtnList和其对panel的控制
public class StateGUI extends Screen {
    public final ResourceLocation bg = new ResourceLocation(ModStateGUI.MODID, "textures/gui/stategui_background.png");
    public final int GUI_WIDTH = 332;
    public final int GUI_HEIGHT = 249;
    public int guiLeft = (this.width - GUI_WIDTH) / 2;
    public int guiTop = (this.height - GUI_HEIGHT) / 2;

    private StatePanel currentPanel;
    private List<StatePanel> allPanel;
    private List<StateButton> allButton;

    //TODO:new GUI
    protected StateGUI(ITextComponent titleIn) {
        super(titleIn);
        //检查注册表里所有的panel并创建实例
    }

    @Override
    public void init(Minecraft minecraft, int width, int height) {
        super.init(minecraft, width, height);

        guiLeft = (this.width - GUI_WIDTH) / 2;
        guiTop = (this.height - GUI_HEIGHT) / 2;

        currentPanel = new TagPanel(this);

        this.children.add(currentPanel);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        guiLeft = (this.width - GUI_WIDTH) / 2;
        guiTop = (this.height - GUI_HEIGHT) / 2;
        renderBackground(matrixStack);
        if (currentPanel !=null){
            currentPanel.render(matrixStack,mouseX,mouseY,partialTicks);
        }
    }

    @Override
    public void renderBackground(@Nonnull MatrixStack matrixStack) {
        super.renderBackground(matrixStack);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(bg);
        blit(matrixStack,guiLeft,guiTop,0,0,332,249,332,249);
    }

    public static class OpenGUI{
        public OpenGUI(){ Minecraft.getInstance().displayGuiScreen(new StateGUI(new TranslationTextComponent(ModStateGUI.MODID + ".statusgui")));}
    }
}
