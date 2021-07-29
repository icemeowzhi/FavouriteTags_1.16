package com.imz.favourite_tags.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class TagGUI implements Command<CommandSource> {
    public static TagGUI instance = new TagGUI();

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getEntity() instanceof PlayerEntity) {
            //if (context.getSource().getWorld().isRemote()){
                DistExecutor.safeCallWhenOn(Dist.CLIENT, () -> com.imz.favourite_tags.gui.TagGUI.OpenGUI::new);
                //context.getSource().sendFeedback(new StringTextComponent("executed"), false);
            //}
        }
        return 0;
    }
}
