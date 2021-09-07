package com.imz.favourite_tags.command;

import com.imz.StateGUI.client.gui.StateGUI;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class TagGUICommand implements Command<CommandSource> {
    public static TagGUICommand instance = new TagGUICommand();
    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getEntity() instanceof PlayerEntity){
            new StateGUI.OpenGUI();
        }
        return 0;
    }
}
