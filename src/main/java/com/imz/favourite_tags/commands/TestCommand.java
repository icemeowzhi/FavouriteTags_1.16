package com.imz.favourite_tags.commands;

import com.imz.favourite_tags.Utils.Constants;
import com.imz.favourite_tags.capabilities.CapabilityHandler;
import com.imz.favourite_tags.capabilities.IPlayerTagCapability;
import com.imz.favourite_tags.tag.ITags;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import net.minecraftforge.common.util.LazyOptional;

import java.util.ArrayList;

public class TestCommand implements Command<CommandSource> {
    public static TestCommand instance = new TestCommand();

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getEntity() instanceof PlayerEntity) {
            LazyOptional<IPlayerTagCapability> playerTagCapability = context.getSource().getEntity().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            playerTagCapability.ifPresent((capability) -> {
                ArrayList<ITags> allTags = capability.getAllTags();
                context.getSource().sendFeedback(new TranslationTextComponent("cmd." + Constants.MODID + ".show_tags", allTags), false);
            });
        }
        return 0;
    }
}
