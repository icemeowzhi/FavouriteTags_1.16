package com.imz.StateGUI.client.gui.vanilla;

import com.imz.StateGUI.client.gui.StateGUI;
import com.imz.StateGUI.util.OpenGUIBtnConst;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.item.ItemGroup;

import javax.annotation.Nonnull;
public class ShowTagGuiButtonCreative extends ImageButton {
    CreativeScreen parent;

    public ShowTagGuiButtonCreative(ContainerScreen<?> parent) {
        super(parent.getGuiLeft() + 126, parent.height / 2 - 22, OpenGUIBtnConst.OPEN_GUI_BTN_WIDTH, OpenGUIBtnConst.OPEN_GUI_BTN_HEIGHT,
                OpenGUIBtnConst.OPEN_GUI_BTN_U, OpenGUIBtnConst.OPEN_GUI_BTN_V1, OpenGUIBtnConst.OPEN_GUI_BTN_V2, OpenGUIBtnConst.INV_BTN,
                btn -> new StateGUI.OpenGUI());
        this.parent = (CreativeScreen) parent;
    }

    @Override
    public void renderWidget(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        if (parent.getSelectedTabIndex() == ItemGroup.INVENTORY.getIndex()){
            active = true;
            super.renderWidget(matrixStack, mouseX, mouseY, partialTicks);
            setPosition(parent.getGuiLeft()+126,parent.height / 2 - 35);
        }else {
            active = false;
        }
    }

}
