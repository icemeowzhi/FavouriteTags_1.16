package com.imz.StateGUI.client.gui.widget;

import com.imz.StateGUI.ModStateGUI;
import com.imz.favourite_tags.foodtag.EnumRarity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.IBidiTooltip;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.List;
import java.util.Optional;

/**
 * @author icemeowzhi
 * @date 2021/9/7
 * @apiNote
 */
public class TagWidget extends Widget implements IBidiTooltip {
    Screen parent;
    EnumRarity rarity;
    List<IReorderingProcessor> tooltips;
    final ResourceLocation widgetTexture = new ResourceLocation(ModStateGUI.MODID, "textures/gui/stategui_widget.png");

    public TagWidget(int x, int y, ITextComponent title, Screen parent, EnumRarity rarity, List<IReorderingProcessor> tooltips) {
        super(x, y, 29, 11, title);
        this.parent = parent;
        this.rarity = rarity;
        this.tooltips = tooltips;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);

    }

    @Override
    public void renderToolTip(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.renderToolTip(matrixStack, mouseX, mouseY);
        func_241867_d().ifPresent((tooltip)->{
            parent.renderToolTip(matrixStack,tooltip, mouseX,mouseY,parent.getMinecraft().fontRenderer);
        });

    }

    @Override
    public void renderWidget(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        int uOffset = 80;
        int vOffset;
        switch (rarity){
            case EPIC:
                vOffset = 32;
                break;
            case RARE:
                vOffset = 43;
                break;
            case UNCOMMON:
                vOffset = 54;
                break;
            default:
                vOffset = 65;
        }
        this.parent.getMinecraft().getTextureManager().bindTexture(widgetTexture);
        parent.blit(matrixStack,x,y,uOffset,vOffset,width,height);

        if (this.isHovered()) {
            this.renderToolTip(matrixStack, mouseX, mouseY);
        }
    }

    @Override
    public Optional<List<IReorderingProcessor>> func_241867_d() {
        return Optional.of(tooltips);
    }


}
