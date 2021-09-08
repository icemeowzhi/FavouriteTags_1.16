package com.imz.favourite_tags.client.renderer.gui.widget;

import com.google.common.collect.Lists;
import com.imz.StateGUI.client.gui.StateGUI;
import com.imz.StateGUI.client.gui.widget.StatePanel;
import com.imz.StateGUI.client.gui.widget.TagCategoryWidget;
import com.imz.StateGUI.client.gui.widget.TagWidget;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.foodtag.FoodTag;
import com.imz.favourite_tags.foodtag.PlayerFedUpState;
import com.imz.favourite_tags.foodtag.PlayerFoodTagState;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author icemeowzhi
 * @date 2021/9/7
 * @apiNote
 */
public class TagPanel extends StatePanel {
    Map<FoodTag, PlayerFoodTagState> foodTagLikeSource;
    Map<FoodTag, PlayerFoodTagState> foodTagDislikeSource;
    Map<FoodTag, PlayerFedUpState> fedUpSource;
    List<FoodTag> tagLikeList;
    List<TagWidget> tagLikeWidgetList;
    List<FoodTag> tagDislikeList;
    List<TagWidget> tagDislikeWidgetList;
    TagCategoryWidget categoryLike;
    TagCategoryWidget categoryDislike;


    public TagPanel(StateGUI parent) {
        super(parent);

        //初始化
        AtomicReference<Map<FoodTag, PlayerFoodTagState>> foodLike = new AtomicReference<>();
        AtomicReference<Map<FoodTag, PlayerFoodTagState>> foodDislike = new AtomicReference<>();
        assert parent.getMinecraft().player != null;
        parent.getMinecraft().player.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap)->{
            foodLike.set(cap.getLike());
            foodDislike.set(cap.getDisLike());
        });

        AtomicReference<Map<FoodTag, PlayerFedUpState>> foodFedUp = new AtomicReference<>();
        parent.getMinecraft().player.getCapability(CapabilityHandler.PLAYER_FED_UP_CAPABILITY).ifPresent((cap)->{
            foodFedUp.set(cap.getFoodTagFedUp());
        });

        //得到cap，失败就不显示
        if (foodLike.get() != null && foodDislike.get() != null && foodFedUp.get()!=null){
            foodTagLikeSource = foodLike.get();
            foodTagDislikeSource = foodDislike.get();
            fedUpSource = foodFedUp.get();
        }else {
            foodTagLikeSource = new HashMap<>();;
            foodTagDislikeSource = new HashMap<>();
            fedUpSource = new HashMap<>();
        }

        categoryLike = new TagCategoryWidget(0,0,new StringTextComponent("tag_category"),parent,new TranslationTextComponent("tag.label.like"));
        categoryDislike = new TagCategoryWidget(0,0,new StringTextComponent("tag_category"),parent,new TranslationTextComponent("tag.label.dislike"));

        //初始化喜欢的tag
        tagLikeList = Lists.newArrayList(foodTagLikeSource.keySet());
        tagLikeWidgetList = Lists.newArrayList();
        for (FoodTag foodTag : tagLikeList){
            List<IReorderingProcessor> tooltips = new ArrayList<>();
            //名字
            tooltips.add(new TranslationTextComponent("tag.name")
                    .appendSibling(new StringTextComponent("\""))
                    .appendSibling(foodTag.getDisplayName())
                    .appendSibling(new StringTextComponent("\""))
                    .func_241878_f());

            if (foodTagLikeSource.get(foodTag)!=null){
                //稀有度
                tooltips.add(foodTagLikeSource.get(foodTag).getRarity().getDisplayName().func_241878_f());

                //是否原生
                if (foodTagLikeSource.get(foodTag).isInherent()){
                    tooltips.add(new TranslationTextComponent("tag.inherent.true.name").func_241878_f());
                }else {
                    tooltips.add(new TranslationTextComponent("tag.inherent.false.name").func_241878_f());
                }

                //厌倦度
                if (foodTagLikeSource.get(foodTag).isUniqueTag()){
                    tooltips.add(new TranslationTextComponent("fed_up.unique.name").func_241878_f());
                }else {
                    tooltips.add(new TranslationTextComponent("fed_up.name").func_241878_f());
                }
            }

            //x,y 在这里没有用处，会在之后更新
            tagLikeWidgetList.add(new TagWidget(0,0,new StringTextComponent("tag"),parent, foodTagLikeSource.get(foodTag).getRarity(),tooltips,foodTag.getDisplayName()));
        }

        //初始化不喜欢的tag
        tagDislikeList = Lists.newArrayList(foodTagDislikeSource.keySet());
        tagDislikeWidgetList = Lists.newArrayList();
        for (FoodTag foodTag : tagDislikeList){
            List<IReorderingProcessor> tooltips = new ArrayList<>();
            //名字
            tooltips.add(new TranslationTextComponent("tag.name")
                    .appendSibling(new StringTextComponent("\""))
                    .appendSibling(foodTag.getDisplayName())
                    .appendSibling(new StringTextComponent("\""))
                    .func_241878_f());

            if (foodTagDislikeSource.get(foodTag)!=null){
                //是否原生
                if (foodTagDislikeSource.get(foodTag).isInherent()){
                    tooltips.add(new TranslationTextComponent("tag.inherent.true.name").func_241878_f());
                }else {
                    tooltips.add(new TranslationTextComponent("tag.inherent.false.name").func_241878_f());
                }

                //厌倦度
                if (foodTagDislikeSource.get(foodTag).isUniqueTag()){
                    tooltips.add(new TranslationTextComponent("fed_up.unique.name").func_241878_f());
                }else {
                    tooltips.add(new TranslationTextComponent("fed_up.name").func_241878_f());
                }
            }

            //x,y 在这里没有用处，会在之后更新
            tagDislikeWidgetList.add(new TagWidget(0,0,new StringTextComponent("tag"),parent, foodTagDislikeSource.get(foodTag).getRarity(),tooltips,foodTag.getDisplayName()));
        }

    }

    @Override
    protected int getContentHeight() {
        int height = 43;
        height += (15 * ((tagLikeList.size()+1) /2));
        height += (15 * ((tagDislikeList.size()+1) /2));
        if (height < this.bottom - this.top - 14)
            height = this.bottom - this.top - 14;
        return height;
    }

    @Override
    protected void drawPanel(MatrixStack mStack, int entryRight, int relativeY, Tessellator tess, int mouseX, int mouseY, float partialTicks) {
        categoryLike.setPosition(left+7,relativeY);
        categoryLike.render(mStack,mouseX,mouseY,partialTicks);
        relativeY += 19;

        int column = 1;
        int renderX;
        for (TagWidget tagWidget:tagLikeWidgetList){
            if (column == 1){
                renderX = left+7;
            }else {
                renderX = left+82+7;
            }
            tagWidget.setPosition(renderX,relativeY);
            tagWidget.render(mStack,mouseX,mouseY,partialTicks);
            Style style = tagWidget.getRenderedText().getStyle();//.setBold(true);
            parent.getMinecraft().fontRenderer.drawText(mStack, tagWidget.getRenderedText().copyRaw().setStyle(style), renderX + 4 + 30, relativeY + 2, 0xff474657);

            column++;
            if (column>2){
                column = 1;
                relativeY += 14;
            }
        }

        if(column == 2){
            relativeY+=14;
        }

        relativeY += 3;

        categoryDislike.setPosition(left+7,relativeY);
        categoryDislike.render(mStack,mouseX,mouseY,partialTicks);
        relativeY += 19;
        column = 1;
        for (TagWidget tagWidget:tagDislikeWidgetList){
            if (column == 1){
                renderX = left+7;
            }else {
                renderX = left+82+7;
            }
            tagWidget.setPosition(renderX,relativeY);
            tagWidget.render(mStack,mouseX,mouseY,partialTicks);
            Style style = tagWidget.getRenderedText().getStyle();//.setBold(true);
            parent.getMinecraft().fontRenderer.drawText(mStack, tagWidget.getRenderedText().copyRaw().setStyle(style), renderX + 4 + 30, relativeY + 2, 0xff474657);

            column++;
            if (column>2){
                column = 1;
                relativeY += 14;
            }
        }
    }

    @Override
    public void render(@Nonnull MatrixStack matrix, int mouseX, int mouseY, float partialTicks) {
        super.render(matrix, mouseX, mouseY, partialTicks);
        if (categoryLike.isHovered()){
            categoryLike.renderToolTip(matrix,mouseX,mouseY);
        }
        if (categoryDislike.isHovered()){
            categoryDislike.renderToolTip(matrix,mouseX,mouseY);
        }
        for (TagWidget tagWidget:tagLikeWidgetList){
            if (tagWidget.isHovered()){
                tagWidget.renderToolTip(matrix,mouseX,mouseY);
            }
        }
        for (TagWidget tagWidget:tagDislikeWidgetList){
            if (tagWidget.isHovered()){
                tagWidget.renderToolTip(matrix,mouseX,mouseY);
            }
        }
    }

}
