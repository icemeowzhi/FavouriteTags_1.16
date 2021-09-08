package com.imz.StateGUI.client.gui.widget;

import com.google.common.collect.Lists;
import com.imz.StateGUI.ModStateGUI;
import com.imz.StateGUI.client.gui.StateGUI;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FocusableGui;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.IRenderable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.client.gui.GuiUtils;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/8/6
 * @apiNote
 */
public abstract class StatePanel extends FocusableGui implements IRenderable {
    private final Minecraft client;
    private final ResourceLocation widgets_icon = new ResourceLocation(ModStateGUI.MODID, "textures/gui/stategui_widget.png");
    protected StateGUI parent;
    protected final int width;
    protected final int height;
    protected int top;
    protected int bottom;
    protected int right;
    protected int left;
    protected boolean scrolling;
    protected float scrollDistance;
    protected boolean captureMouse = true;
    protected final int border = 7;
    protected final int barWidth = 12;
    protected int barLeft;
    protected List<IReorderingProcessor> lines;

    public StatePanel(StateGUI parent)
    {
        this.client = Minecraft.getInstance();
        this.width = 192;
        this.height = 205;

        //这五个值在错误的时候调用了parent，导致它们的值不可信
        //这些值会在渲染时刷新
        this.top = parent.guiTop+22;
        this.left = parent.guiLeft+120;
        this.bottom = height + this.top;
        this.right = width + this.left;
        this.barLeft = this.left + this.width - barWidth;

        this.lines = Lists.newArrayList();
        this.parent = parent;

    }

    protected abstract int getContentHeight();

    protected void drawBackground() {}


    protected abstract void drawPanel(MatrixStack mStack, int entryRight, int relativeY, Tessellator tess, int mouseX, int mouseY, float partialTicks);

    protected boolean clickPanel(double mouseX, double mouseY, int button) { return false; }

    private int getMaxScroll()
    {
        return this.getContentHeight() - (this.height - this.border);
    }

    private void applyScrollLimits()
    {
        int max = getMaxScroll();

        if (max < 0)
        {
            max /= 2;
        }

        if (this.scrollDistance < 0.0F)
        {
            this.scrollDistance = 0.0F;
        }

        if (this.scrollDistance > max)
        {
            this.scrollDistance = max;
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scroll)
    {
        if (scroll != 0)
        {
            this.scrollDistance += -scroll * getScrollAmount();
            applyScrollLimits();
            return true;
        }
        return false;
    }

    protected int getScrollAmount()
    {
        return 20;
    }

    @Override
    public boolean isMouseOver(double mouseX, double mouseY)
    {
        return mouseX >= this.left && mouseX <= this.left + this.width &&
                mouseY >= this.top && mouseY <= this.bottom;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (super.mouseClicked(mouseX, mouseY, button))
            return true;

        this.scrolling = button == 0 && mouseX >= barLeft && mouseX < barLeft + barWidth && mouseY >= top && mouseY< bottom;
        if (this.scrolling)
        {
            return true;
        }
        int mouseListY = ((int)mouseY) - this.top - this.getContentHeight() + (int)this.scrollDistance - border;
        if (mouseX >= left && mouseX <= right && mouseListY < 0)
        {
            return this.clickPanel(mouseX - left, mouseY - this.top + (int)this.scrollDistance - border, button);
        }
        return false;
    }

    @Override
    public boolean mouseReleased(double p_mouseReleased_1_, double p_mouseReleased_3_, int p_mouseReleased_5_) {
        if (super.mouseReleased(p_mouseReleased_1_, p_mouseReleased_3_, p_mouseReleased_5_))
            return true;
        boolean ret = this.scrolling;
        this.scrolling = false;
        return ret;
    }

    private int getBarHeight()
    {
        return 15;
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY)
    {
        if (this.scrolling)
        {
            int maxScroll = height - getBarHeight();
            double moved = deltaY / maxScroll;
            this.scrollDistance += getMaxScroll() * moved;
            applyScrollLimits();
            return true;
        }
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void render(@Nonnull MatrixStack matrix, int mouseX, int mouseY, float partialTicks)
    {
        this.drawBackground();
        top = parent.guiTop+22;
        left = parent.guiLeft+120;
        bottom = height + this.top;
        right = width + this.left;
        barLeft = this.left + this.width - barWidth;

        Tessellator tess = Tessellator.getInstance();
        BufferBuilder worldr = tess.getBuffer();

        double scale = client.getMainWindow().getGuiScaleFactor();
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        GL11.glScissor((int)(left  * scale), (int)(client.getMainWindow().getFramebufferHeight() - (bottom * scale)),
                (int)(width * scale), (int)(height * scale));

        int baseY = this.top + border - (int)this.scrollDistance;
        this.drawPanel(matrix, right, baseY, tess, mouseX, mouseY, partialTicks);

        RenderSystem.disableDepthTest();

        int extraHeight = (this.getContentHeight() + border) - height;
        if (extraHeight > 0)
        {
            int barHeight = getBarHeight();

            int barTop = (int)this.scrollDistance * (height - barHeight) / extraHeight + this.top;
            if (barTop < this.top)
            {
                barTop = this.top;
            }
            RenderSystem.enableTexture();
            Minecraft.getInstance().getTextureManager().bindTexture(widgets_icon);
            Screen.blit(matrix,barLeft,barTop,0,0,12,15,256,256);
        }

        RenderSystem.enableTexture();
        RenderSystem.shadeModel(GL11.GL_FLAT);
        RenderSystem.enableAlphaTest();
        RenderSystem.disableBlend();
        GL11.glDisable(GL11.GL_SCISSOR_TEST);

    }

    protected void drawGradientRect(MatrixStack mStack, int left, int top, int right, int bottom, int color1, int color2)
    {
        GuiUtils.drawGradientRect(mStack.getLast().getMatrix(), 0, left, top, right, bottom, color1, color2);
    }

    @Nonnull
    @Override
    public List<? extends IGuiEventListener> getEventListeners()
    {
        return Collections.emptyList();
    }

    public abstract ITextComponent getTitle();
}

