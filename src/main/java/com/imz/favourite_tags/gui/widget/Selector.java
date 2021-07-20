package com.imz.favourite_tags.gui.widget;

import com.imz.favourite_tags.util.Constants;
import com.imz.favourite_tags.gui.ICustomButton;
import com.imz.favourite_tags.gui.LangDifferedResourceLocationManger;
import com.imz.favourite_tags.tag.EnumCategory;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

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
        minecraft = screen.getMinecraft();
        windowPanel = windowToControl;
        this.customButtonScreen = customButtonScreen;
    }

    public void registerBtn(){
        int btnX = Constants.CATEGORY_SELECTOR_X + 1;
        int btnY = Constants.CATEGORY_SELECTOR_Y + 1;
        ResourceLocation texture = LangDifferedResourceLocationManger.getCategoryLangDifferedTexture(
                minecraft.getLanguageManager().getCurrentLanguage().getCode());

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
                    (button)->{}));//TODO:得到capability 然后refresh()
        }

        for (Button button: btnList) {
            customButtonScreen.addButton(button);
        }
    }

    @Override
    public void init(MatrixStack matrixStack) {

    }
}
