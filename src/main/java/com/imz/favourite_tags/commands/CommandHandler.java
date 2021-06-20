package com.imz.favourite_tags.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandHandler{
    @SubscribeEvent
    public static void onServerStaring(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
        LiteralCommandNode<CommandSource> cmd = dispatcher.register(
                Commands.literal("showtag").then(
                        Commands.literal("player")
                                .requires((commandSource) -> commandSource.hasPermissionLevel(0))
                                .executes(TestCommand.instance)
                )
        );
        dispatcher.register(Commands.literal("sp").redirect(cmd));
    }
}
