package com.imz.favourite_tags.gui.renderer;

import com.imz.favourite_tags.util.Constants;
import com.imz.favourite_tags.tag.EnumTagGroup;
import com.imz.favourite_tags.tag.EnumTagRarity;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.ITags;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;

/*
关于tag渲染的代码。
提供一个Tags，生成他的渲染代码。
 */
public class TagsRenderer implements IRenderable {
    ITags tags;
    Vector2f startPos;
    int renderPosX;
    int renderPosY;

    public TagsRenderer(ITags tags,Vector2f startPos){
        this.tags = tags;
        this.startPos = startPos;
        this.renderPosX = (int) startPos.x;
        this.renderPosY = (int) startPos.y;
    }

    @Override
    public Vector2f getStartPos() {
        return startPos;
    }

    @Override
    public void render(MatrixStack matrixStack) {
        //初始化
        int tagCount = 0;
        renderPosX = (int) startPos.x;
        renderPosY = (int) startPos.y;

        //标题的外边框
        Screen.blit(matrixStack,renderPosX, renderPosY,
                Constants.GROUP_U,Constants.GROUP_V,
                Constants.GROUP_WIDTH,Constants.GROUP_HEIGHT,
                Constants.GROUP_WIDTH,Constants.GROUP_HEIGHT);

        //标题
        if (tags.getTagsGroup() == EnumTagGroup.FOODS_LIKE){

            Screen.drawString(matrixStack, Minecraft.getInstance().fontRenderer,
                    new TranslationTextComponent("tag.label.like"),
                    renderPosX+5,renderPosY+Constants.GROUP_HEIGHT/2,
                    0x00000000);

        }else if(tags.getTagsGroup() == EnumTagGroup.FOODS_DISLIKE){

            Screen.drawString(matrixStack, Minecraft.getInstance().fontRenderer,
                    new TranslationTextComponent("tag.label.dislike"),
                    renderPosX+5,renderPosY+Constants.GROUP_HEIGHT/2,
                    0x00000000);

        }

        //每个entry
        ArrayList<ITag> tagList = tags.getAllTags();
        //渲染点初始化
        renderPosY = renderPosY + Constants.ENTRY_HEIGHT + Constants.GROUP_TO_ENTRY_Y;

        for (ITag tag : tagList){
            tagCount += 1;
            renderEntry(matrixStack,tag,renderPosX,renderPosY);
            if (tagCount % 2 == 1){
                //渲染在左边，之后改变渲染点
                renderPosX = renderPosX + Constants.ENTRY_WIDTH + Constants.NEXT_ENTRY_X;
            }else {
                //渲染在右边，之后使渲染点归位
                renderPosX = renderPosX - Constants.ENTRY_WIDTH - Constants.NEXT_ENTRY_X;
                renderPosY = renderPosY + Constants.ENTRY_HEIGHT + Constants.NEXT_ENTRY_Y;
            }
        }
    }

    @Override
    public int getRenderEnd() {
        int count = tags.getAllTags().size();
        int tagRow = (count+1) / 2;
        return tagRow*Constants.ENTRY_HEIGHT + (tagRow-1)*Constants.NEXT_ENTRY_Y +
                Constants.GROUP_TO_ENTRY_Y + Constants.GROUP_HEIGHT +
                Constants.ENTRY_TO_GROUP_Y;
    }

    private void renderEntry(MatrixStack matrixStack,ITag tag,int renderPosX,int renderPosY){
        Screen.blit(matrixStack,renderPosX,renderPosY,
                Constants.ENTRY_U,Constants.ENTRY_V,
                Constants.ENTRY_WIDTH,Constants.ENTRY_HEIGHT,
                Constants.ENTRY_WIDTH,Constants.ENTRY_HEIGHT);

        renderTag(matrixStack,tag.getTagRarity(),renderPosX,renderPosY);

        Screen.drawString(matrixStack,Minecraft.getInstance().fontRenderer,
                tag.getDisplayName(),
                renderPosX + Constants.ENTRY_TO_TAG_XY + Constants.TAG_WIDTH + 5, renderPosY + Constants.ENTRY_HEIGHT/2,
                0x00000000);
    }

    private void renderTag(MatrixStack matrixStack,EnumTagRarity rarity,int entryPosX,int entryPosY){
        int tagU;
        int tagV;
        switch (rarity){
            case EPIC:
                tagU = Constants.EPIC_TAG_U;
                tagV = Constants.EPIC_TAG_V;
                break;
            case RARE:
                tagU = Constants.RARE_TAG_U;
                tagV = Constants.RARE_TAG_V;
                break;
            case UNCOMMON:
                tagU = Constants.UNCOMMON_TAG_U;
                tagV = Constants.UNCOMMON_TAG_V;
                break;
            default:
                tagU = Constants.COMMON_TAG_U;
                tagV = Constants.COMMON_TAG_V;
        }

        Screen.blit(matrixStack , entryPosX + Constants.ENTRY_TO_TAG_XY , entryPosY + Constants.ENTRY_TO_TAG_XY,
                tagU,tagV,
                Constants.TAG_WIDTH,Constants.TAG_HEIGHT,
                Constants.TAG_WIDTH,Constants.TAG_HEIGHT);

    }

}
