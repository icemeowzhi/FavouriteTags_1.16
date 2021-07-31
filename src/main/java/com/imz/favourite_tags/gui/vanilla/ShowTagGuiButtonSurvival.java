package com.imz.favourite_tags.gui.vanilla;

import com.imz.favourite_tags.gui.TagGUI;
import com.imz.favourite_tags.util.Constants;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.ImageButton;

import javax.annotation.Nonnull;

public class ShowTagGuiButtonSurvival extends ImageButton {
    ContainerScreen<?> parent;
    public ShowTagGuiButtonSurvival(ContainerScreen<?> parent) {
        super(parent.getGuiLeft() + 126, parent.height / 2 - 22, Constants.OPEN_GUI_BTN_WIDTH, Constants.OPEN_GUI_BTN_HEIGHT,
                Constants.OPEN_GUI_BTN_U, Constants.OPEN_GUI_BTN_V1, Constants.OPEN_GUI_BTN_V2, Constants.INV_BTN,
                (btn)-> new TagGUI.OpenGUI());
        this.parent = parent;
    }

    @Override
    public void renderWidget(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.renderWidget(matrixStack, mouseX, mouseY, partialTicks);
        setPosition(parent.getGuiLeft()+126,parent.height / 2 - 22);
    }
}
