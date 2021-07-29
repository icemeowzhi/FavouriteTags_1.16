package com.imz.favourite_tags.gui;

import com.google.common.collect.Lists;
import com.imz.favourite_tags.gui.renderer.SimpleTextRenderer;
import com.imz.favourite_tags.gui.widget.IWidget;
import com.imz.favourite_tags.gui.widget.SelectedWindow;
import com.imz.favourite_tags.gui.widget.Selector;
import com.imz.favourite_tags.util.Constants;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class TagGUI extends Screen implements ICustomButton,IWidgetManager{
    ArrayList<IWidget> widgets = new ArrayList<>();
    public SelectedWindow selectedWindow = new SelectedWindow();
    Selector selector = new Selector(this,this,selectedWindow);


    protected TagGUI(ITextComponent p_i51108_1_) {
        super(p_i51108_1_);
        widgets.add(selectedWindow);
        widgets.add(selector);
    }

    @Override
    protected void init() {
        super.init();
        selector.registerBtn((this.width - 256) / 2,(this.height - 256) / 2);
        selectedWindow.refresh(Lists.newArrayList(new SimpleTextRenderer(new Vector2f((float) ((this.width - 256) / 2)+161,((float) (this.height - 256) / 2)+122),
                new TranslationTextComponent("tag.gui.not.clicked"), true,0x008785a2)));
    }

    @Override
    public void render(@Nonnull MatrixStack p_230430_1_, int p_230430_2_, int p_230430_3_, float p_230430_4_) {
        //super.render(p_230430_1_, p_230430_2_, p_230430_3_, p_230430_4_);
        this.renderBackground(p_230430_1_);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(Constants.BG);
        int i = (this.width - 256) / 2;
        int j = (this.height - 256) / 2;
        blit(p_230430_1_,i,j,0,0,256,256,256,256);
        this.minecraft.getTextureManager().bindTexture(Constants.UI);
        initAll(p_230430_1_,p_230430_2_,p_230430_3_,p_230430_4_,i,j);
    }

    @Override
    public void addButton(Button button) {
        super.addButton(button);
    }

    @Override
    public List<IWidget> getWidgets() {
        return widgets;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        InputMappings.Input key = InputMappings.getInputByCode(keyCode,scanCode);
        assert this.minecraft != null;
        if(this.minecraft.gameSettings.keyBindInventory.isActiveAndMatches(key)){
            assert minecraft.player != null;
            minecraft.displayGuiScreen(new InventoryScreen(minecraft.player));
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public static class OpenGUI{
        public OpenGUI(){ Minecraft.getInstance().displayGuiScreen(new TagGUI(new TranslationTextComponent(Constants.MODID + ".tagGUI")));}
    }
}

