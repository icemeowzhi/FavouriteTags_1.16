package com.imz.favourite_tags.command;

import com.imz.favourite_tags.FavouriteTag;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
@Mod.EventBusSubscriber(modid = FavouriteTag.MODID)
public class CommandHandler {
    @SubscribeEvent
    public static void onServerStaring(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
        LiteralCommandNode<CommandSource> showtag = dispatcher.register(
                Commands.literal("showtag").requires((commandSource) -> commandSource.hasPermissionLevel(0))
                        .executes(ShowTagCommand.instance)
        );
        dispatcher.register(Commands.literal("st").redirect(showtag));

        LiteralCommandNode<CommandSource> refresh = dispatcher.register(
                Commands.literal("refreshtag").requires((commandSource) -> commandSource.hasPermissionLevel(0))
                        .executes(RefreshCommand.instance)
        );

        LiteralCommandNode<CommandSource> taggui = dispatcher.register(
                Commands.literal("taggui").requires((commandSource) -> commandSource.hasPermissionLevel(0))
                        .executes(TagGUICommand.instance)
        );

    }
}
