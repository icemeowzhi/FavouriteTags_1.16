package com.imz.favourite_tags.command;

import com.imz.favourite_tags.Utils.Constants;
import com.imz.favourite_tags.capabilities.CapabilityHandler;
import com.imz.favourite_tags.capabilities.IPlayerTagCapability;
import com.imz.favourite_tags.capabilities.PlayerTagCapabilityProvider;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;

public class Refresh implements Command<CommandSource> {
    public static Refresh instance = new Refresh();

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getEntity() instanceof PlayerEntity) {
            LazyOptional<IPlayerTagCapability> playerTagCapability = context.getSource().getEntity().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            playerTagCapability.ifPresent((capability) -> {
                capability.deserializeNBT(new PlayerTagCapabilityProvider((PlayerEntity) context.getSource().getEntity()).serializeNBT());
                context.getSource().sendFeedback(new TranslationTextComponent("cmd." + Constants.MODID + ".refresh_tags"), false);
            });
        }
        return 0;
    }
}
