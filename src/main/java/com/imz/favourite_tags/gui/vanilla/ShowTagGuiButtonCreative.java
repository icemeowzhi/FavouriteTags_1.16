package com.imz.favourite_tags.gui.vanilla;

import com.imz.favourite_tags.gui.TagGUI;
import com.imz.favourite_tags.util.Constants;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.screen.inventory.CreativeScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.item.ItemGroup;

import javax.annotation.Nonnull;

public class ShowTagGuiButtonCreative extends ImageButton {
    CreativeScreen parent;

    public ShowTagGuiButtonCreative(ContainerScreen<?> parent) {
        super(parent.getGuiLeft() + 126, parent.height / 2 - 22, Constants.OPEN_GUI_BTN_WIDTH, Constants.OPEN_GUI_BTN_HEIGHT,
                Constants.OPEN_GUI_BTN_U, Constants.OPEN_GUI_BTN_V1, Constants.OPEN_GUI_BTN_V2, Constants.INV_BTN,
                btn -> new TagGUI.OpenGUI());
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
