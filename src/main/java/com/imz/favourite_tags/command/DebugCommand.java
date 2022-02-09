package com.imz.favourite_tags.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.FoodStats;
import net.minecraft.util.text.StringTextComponent;

/**
 * @author icemeowzhi
 * @date 28/1/2022
 * @apiNote
 */
public class DebugCommand implements Command<CommandSource> {
    public static DebugCommand instance = new DebugCommand();

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getEntity() instanceof PlayerEntity) {
            context.getSource().sendFeedback(new StringTextComponent("Debug message sent."), false);
            FoodStats foodStats =((PlayerEntity) context.getSource().getEntity()).getFoodStats();
            context.getSource().sendFeedback(new StringTextComponent("FoodLevel:"+foodStats.getFoodLevel()), false);
            context.getSource().sendFeedback(new StringTextComponent("Saturation:"+foodStats.getSaturationLevel()), false);
        }
        return 0;
    }
}
