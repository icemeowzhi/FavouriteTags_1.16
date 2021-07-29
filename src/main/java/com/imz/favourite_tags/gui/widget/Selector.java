package com.imz.favourite_tags.gui.widget;

import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.capability.PlayerTagCapability;
import com.imz.favourite_tags.gui.ICustomButton;
import com.imz.favourite_tags.gui.LangDifferedResourceLocationManger;
import com.imz.favourite_tags.gui.renderer.IRenderable;
import com.imz.favourite_tags.gui.renderer.TagsRenderer;
import com.imz.favourite_tags.tag.EnumCategory;
import com.imz.favourite_tags.tag.ITags;
import com.imz.favourite_tags.util.Constants;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/*
需要给SelectedWindow提供一个renderable对象，来进行窗口的更新。
 */
public class Selector implements IWidget {

    Minecraft minecraft;
    SelectedWindow windowPanel;
    EnumCategory[] categories = new EnumCategory[]{EnumCategory.INTEREST};
    List<ImageButton> btnList = new ArrayList<>();
    Screen screen;
    ICustomButton customButtonScreen;

    public Selector(Screen screen,ICustomButton customButtonScreen, SelectedWindow windowToControl){
        this.screen = screen;
        minecraft = Minecraft.getInstance();
        windowPanel = windowToControl;
        this.customButtonScreen = customButtonScreen;
    }

    public void registerBtn(int startPosX,int startPosY){
        btnList.clear();
        int btnX = startPosX+Constants.CATEGORY_SELECTOR_X + 1;
        int btnY = startPosY+Constants.CATEGORY_SELECTOR_Y + 1;
        ResourceLocation texture = LangDifferedResourceLocationManger.getCategoryLangDifferedTexture(
                minecraft.getLanguageManager().getCurrentLanguage().getCode());
        this.minecraft.getTextureManager().bindTexture(texture);


        for (EnumCategory category: categories) {
            //得到u、v
            int u;
            int v1;
            int v2;
            switch (category){
                case INTEREST:
                    u = Constants.CATEGORY_INTEREST_U;
                    v1 = Constants.CATEGORY_INTEREST_V1;
                    v2 = Constants.CATEGORY_INTEREST_V2;
                    break;
                default:
                    u = 0; v1 = 0; v2 = 0;
            }

            btnList.add(new ImageButton( btnX, btnY, Constants.CATEGORY_WIDTH, Constants.CATEGORY_HEIGHT,
                    u, v1, v2, texture,
                    (button)->{
                        //得到capability
                        AtomicReference<PlayerTagCapability> capability = new AtomicReference<>();
                        assert Minecraft.getInstance().player != null;
                        Minecraft.getInstance().player.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap-> capability.set((PlayerTagCapability) cap)));
                        //得到玩家的tags
                        ArrayList<ITags> allTags = capability.get().getAllTags();
                        int renderX = Constants.FIRST_RENDER_X;
                        int renderY = Constants.FIRST_RENDER_Y;
                        ArrayList<IRenderable> renderList = new ArrayList<>();
                        for (ITags tags: allTags) {
                            //对每一个tags进行检测，检测他们的category
                            if (tags.getTagsGroup().getCategory() == category){
                                TagsRenderer renderer = new TagsRenderer(tags,new Vector2f(renderX,renderY));
                                renderY += renderer.getRenderEnd();
                                renderList.add(renderer);
                            }
                        }
                        windowPanel.refresh(renderList);

                    }));//得到capability 然后refresh()

            btnY += Constants.CATEGORY_HEIGHT + 1;
        }
        //统一进行init()
        for (Button button: btnList) {
            customButtonScreen.addButton(button);
        }
    }

    @Override
    public void init(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks,int startPosX,int startPosY) {
        Screen.blit(matrixStack,startPosX+Constants.CATEGORY_SELECTOR_X,startPosY+Constants.CATEGORY_SELECTOR_Y,0,0,
                Constants.CATEGORY_SELECTOR_WIDTH, Constants.CATEGORY_SELECTOR_HEIGHT,
                256, 256);
        for (Button btn: btnList) {
            btn.render(matrixStack,mouseX,mouseY,partialTicks);
        }
    }
}
