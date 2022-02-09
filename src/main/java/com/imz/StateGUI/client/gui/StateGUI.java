package com.imz.StateGUI.client.gui;

import com.imz.StateGUI.ModStateGUI;
import com.imz.StateGUI.client.PanelInitializer;
import com.imz.StateGUI.client.gui.widget.StateButton;
import com.imz.StateGUI.client.gui.widget.StatePanel;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.util.InputMappings;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/8/2
 * @apiNote
 */
//管理一个BtnList和其对panel的控制
public class StateGUI extends Screen {
    public final ResourceLocation bg = new ResourceLocation(ModStateGUI.MODID, "textures/gui/stategui_background.png");
    public final ResourceLocation widget = new ResourceLocation(ModStateGUI.MODID, "textures/gui/stategui_widget.png");
    public final int GUI_WIDTH = 332;
    public final int GUI_HEIGHT = 236;
    public int guiLeft = (this.width - GUI_WIDTH) / 2;
    public int guiTop = (this.height - GUI_HEIGHT) / 2;

    private StatePanel currentPanel;
    private List<StatePanel> allPanel;
    private int page;
    private int allPage;
    private List<StateButton> buttonsThisPage;
    private List<StateButton> allButton;
    private ImageButton PgUpBtn;
    private ImageButton PgDnBtn;

    int firstBtnIndex;
    int lastBtnIndex;

    protected StateGUI(ITextComponent titleIn) throws RuntimeException {
        super(titleIn);
        //检查注册表里所有的panel并创建实例
        page = 1;
        allPanel = new ArrayList<>();
        allButton = new ArrayList<>();
        Class[] parameterType={StateGUI.class};
        for (Class<? extends StatePanel> panelClass : PanelInitializer.getPanelClassList()){
            try {

                Constructor<? extends StatePanel> constructor = panelClass.getConstructor(parameterType);

                try {

                    StatePanel panelInstance = constructor.newInstance(this);
                    allPanel.add(panelInstance);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Illegal statePanel class! The class cannot be an abstract class or an interface. ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Illegal statePanel class! The class must be public. ");
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    throw new RuntimeException("There is a mistake in you tagPanel class! ");
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                throw new RuntimeException("Illegal statePanel class! The class must have ONE constructor that only have a StateGUI param. ");
            }
        }

        for (StatePanel panel : allPanel){
            allButton.add(new StateButton(0,0,panel.getTitle(),(btn)->{
                currentPanel = panel;
                for (StateButton button:allButton){
                    button.active = true;
                }
                btn.active = false;
            }));
        }

        allPage = (allButton.size()+8)/9;

    }

    @Override
    public void init(@Nonnull Minecraft minecraft, int width, int height) {
        super.init(minecraft, width, height);

        guiLeft = (this.width - GUI_WIDTH) / 2;
        guiTop = (this.height - GUI_HEIGHT) / 2;

        //默认是欢迎页面
        currentPanel = new StatePanel(this) {
            @Override
            protected int getContentHeight() {
                return this.bottom - this.top - 14;
            }

            @Override
            protected void drawPanel(MatrixStack mStack, int entryRight, int relativeY, Tessellator tess, int mouseX, int mouseY, float partialTicks) {
                ITextComponent welcomeText = new TranslationTextComponent("tag.panel.welcome.text");
                Style style = welcomeText.getStyle();//.setBold(true);
                parent.getMinecraft().fontRenderer.drawText(mStack, welcomeText.copyRaw().setStyle(style), left+7, relativeY, 0xff474657);
            }

            @Override
            public ITextComponent getTitle() {
                return new StringTextComponent("welcome");
            }
        };

        for (StatePanel panel:allPanel){
            panel.init();
        }

        this.children.add(currentPanel);
        this.children.addAll(allPanel);
        this.children.addAll(allButton);

        //初始化翻页
        PgUpBtn = new ImageButton(guiLeft+28,guiTop+209,11,17,112,32,17,widget,(btn)->{
            if (page>1) page--;
        });
        PgDnBtn = new ImageButton(guiLeft+80,guiTop+209,11,17,128,32,17,widget,(btn)->{
           if(page<allPage) page++;
        });

        for (StateButton button:allButton){
            button.active = true;
        }

        if (allButton.size() == 0){
            firstBtnIndex = 0;
        }else firstBtnIndex = (page-1)*9+1;
        lastBtnIndex = Math.min(allButton.size(),page*9);

        buttonsThisPage = allButton.subList(firstBtnIndex - 1,lastBtnIndex);

        for (int i = 0; i < buttonsThisPage.size(); i++) {
            buttonsThisPage.get(i).setPosition(guiLeft+20,guiTop+18+i*20);
        }

    }

    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        renderBackground(matrixStack);
        //渲染按钮
        PgUpBtn.render(matrixStack,mouseX,mouseY,partialTicks);
        PgDnBtn.render(matrixStack,mouseX,mouseY,partialTicks);

        for (StateButton stateButton : buttonsThisPage) {
            stateButton.render(matrixStack, mouseX, mouseY, partialTicks);
        }

        //渲染panel
        if (currentPanel !=null){
            currentPanel.render(matrixStack,mouseX,mouseY,partialTicks);
        }
    }

    @Override
    public void renderBackground(@Nonnull MatrixStack matrixStack) {
        super.renderBackground(matrixStack);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(bg);
        blit(matrixStack,guiLeft,guiTop,0,0,GUI_WIDTH,GUI_HEIGHT,GUI_WIDTH,GUI_HEIGHT);
        this.minecraft.getTextureManager().bindTexture(widget);
        blit(matrixStack,guiLeft+45,guiTop+209,112,0,29,17);
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
        public OpenGUI(){ Minecraft.getInstance().displayGuiScreen(new StateGUI(new TranslationTextComponent(ModStateGUI.MODID + ".statusgui")));}
    }
}
