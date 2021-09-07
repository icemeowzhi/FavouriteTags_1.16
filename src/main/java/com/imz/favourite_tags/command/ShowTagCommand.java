package com.imz.favourite_tags.command;

import com.google.common.collect.Lists;
import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.capability.player_tag_capability.IPlayerTagCapability;
import com.imz.favourite_tags.foodtag.FoodTag;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;

import java.util.List;

/**
 * @author icemeowzhi
 * @date 2021/9/6
 * @apiNote
 */
public class ShowTagCommand implements Command<CommandSource> {
    static ShowTagCommand instance = new ShowTagCommand();
    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getEntity() instanceof PlayerEntity) {
            LazyOptional<IPlayerTagCapability> playerTagCapability = context.getSource().getEntity().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            playerTagCapability.ifPresent((capability) -> {
                List<FoodTag> like = Lists.newArrayList(capability.getLike().keySet());
                List<FoodTag> dislike = Lists.newArrayList(capability.getDisLike().keySet());
                context.getSource().sendFeedback(new TranslationTextComponent("cmd." + FavouriteTag.MODID + ".show_tags"), false);
                context.getSource().sendFeedback(new TranslationTextComponent("tag.label.like"), false);
                context.getSource().sendFeedback(new StringTextComponent(like.toString()), false);
                context.getSource().sendFeedback(new TranslationTextComponent("tag.label.dislike"), false);
                context.getSource().sendFeedback(new StringTextComponent(dislike.toString()), false);
            });
        }
        return 0;
    }
}
