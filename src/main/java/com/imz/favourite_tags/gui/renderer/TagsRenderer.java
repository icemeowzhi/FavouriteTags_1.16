package com.imz.favourite_tags.gui.renderer;

import com.imz.favourite_tags.util.Constants;
import com.imz.favourite_tags.tag.EnumTagGroup;
import com.imz.favourite_tags.tag.EnumTagRarity;
import com.imz.favourite_tags.tag.ITag;
import com.imz.favourite_tags.tag.ITags;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.IReorderingProcessor;
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
    public void render(MatrixStack matrixStack,int startPosX,int startPosY) {
        //初始化
        int tagCount = 0;
        renderPosX = (int) startPos.x;
        renderPosY = (int) startPos.y;
        //切换材质
        Minecraft.getInstance().getTextureManager().bindTexture(Constants.UI);

        //标题的外边框
        Screen.blit(matrixStack,startPosX+renderPosX, startPosY+renderPosY,
                Constants.GROUP_U,Constants.GROUP_V,
                Constants.GROUP_WIDTH,Constants.GROUP_HEIGHT,
                256,256);

        //标题
        if (tags.getTagsGroup() == EnumTagGroup.FOODS_LIKE){
/*
            Screen.drawString(matrixStack, Minecraft.getInstance().fontRenderer,
                    new TranslationTextComponent("tag.label.like"),
                    startPosX+renderPosX+5,(startPosY+renderPosY+Constants.GROUP_HEIGHT/2)-4,
                    0x008785a2);

 */

            IReorderingProcessor ireorderingprocessor = new TranslationTextComponent("tag.label.like").func_241878_f();
            Minecraft.getInstance().fontRenderer.func_238422_b_(matrixStack,ireorderingprocessor,
                    startPosX+renderPosX+5,(startPosY+renderPosY+Constants.GROUP_HEIGHT/2)-4,
                    0x008785a2);

        }else if(tags.getTagsGroup() == EnumTagGroup.FOODS_DISLIKE){
/*
            Screen.drawString(matrixStack, Minecraft.getInstance().fontRenderer,
                    new TranslationTextComponent("tag.label.dislike"),
                    startPosX+renderPosX+5,(startPosY+renderPosY+Constants.GROUP_HEIGHT/2)-4,
                    0x008785a2);

 */

            IReorderingProcessor ireorderingprocessor = new TranslationTextComponent("tag.label.dislike").func_241878_f();
            Minecraft.getInstance().fontRenderer.func_238422_b_(matrixStack,ireorderingprocessor,
                    startPosX+renderPosX+5,(startPosY+renderPosY+Constants.GROUP_HEIGHT/2)-4,
                    0x008785a2);

        }
        //切换材质
        Minecraft.getInstance().getTextureManager().bindTexture(Constants.UI);
        //每个entry
        ArrayList<ITag> tagList = tags.getAllTags();
        //渲染点初始化
        renderPosY = renderPosY + Constants.ENTRY_HEIGHT + Constants.GROUP_TO_ENTRY_Y;

        for (ITag tag : tagList){
            tagCount += 1;
            renderEntry(matrixStack,tag,renderPosX,renderPosY,startPosX,startPosY);
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

    private void renderEntry(MatrixStack matrixStack,ITag tag,int renderPosX,int renderPosY,int startPosX,int startPosY){
        Screen.blit(matrixStack,startPosX+renderPosX,startPosY+renderPosY,
                Constants.ENTRY_U,Constants.ENTRY_V,
                Constants.ENTRY_WIDTH,Constants.ENTRY_HEIGHT,
                256,256);

        renderTag(matrixStack,tag.getTagRarity(),renderPosX,renderPosY,startPosX,startPosY);
/*
        Screen.drawString(matrixStack,Minecraft.getInstance().fontRenderer,
                tag.getDisplayName(),
                startPosX+renderPosX + Constants.ENTRY_TO_TAG_XY + Constants.TAG_WIDTH + 5, (startPosY + renderPosY + Constants.ENTRY_HEIGHT/2) - 4,
                0x008785a2);

 */
        IReorderingProcessor ireorderingprocessor = tag.getDisplayName().func_241878_f();
        Minecraft.getInstance().fontRenderer.func_238422_b_(matrixStack,ireorderingprocessor,
                startPosX+renderPosX + Constants.ENTRY_TO_TAG_XY + Constants.TAG_WIDTH + 5,(startPosY + renderPosY + Constants.ENTRY_HEIGHT/2) - 4,
                0x008785a2);
        Minecraft.getInstance().getTextureManager().bindTexture(Constants.UI);
    }

    private void renderTag(MatrixStack matrixStack,EnumTagRarity rarity,int entryPosX,int entryPosY,int startPosX,int startPosY){
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

        Screen.blit(matrixStack , startPosX + entryPosX + Constants.ENTRY_TO_TAG_XY , startPosY + entryPosY + Constants.ENTRY_TO_TAG_XY,
                tagU,tagV,
                Constants.TAG_WIDTH,Constants.TAG_HEIGHT,
                256,256);

    }

}
