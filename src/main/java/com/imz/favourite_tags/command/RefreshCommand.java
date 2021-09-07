package com.imz.favourite_tags.command;

import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.capability.player_tag_capability.IPlayerTagCapability;
import com.imz.favourite_tags.capability.player_tag_capability.PlayerTagCapabilityProvider;
import com.imz.favourite_tags.network.NetworkHandler;
import com.imz.favourite_tags.network.PlayerTagCapPack;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.PacketDistributor;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class RefreshCommand implements Command<CommandSource> {
    public static RefreshCommand instance = new RefreshCommand();
    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        if (context.getSource().getEntity() instanceof PlayerEntity) {
            LazyOptional<IPlayerTagCapability> playerTagCapability = context.getSource().getEntity().getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY);
            playerTagCapability.ifPresent((capability) -> {
                CompoundNBT newNbt = new PlayerTagCapabilityProvider((PlayerEntity) context.getSource().getEntity()).serializeNBT();
                //应用到服务端
                capability.deserializeNBT(newNbt);
                //发包同步
                if (!context.getSource().getWorld().isRemote()){
                    NetworkHandler.INSTANCE.send(
                            PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) context.getSource().getEntity()),
                            new PlayerTagCapPack(newNbt));
                }

                context.getSource().sendFeedback(new TranslationTextComponent("cmd." + FavouriteTag.MODID + ".refresh_tags"), false);
            });
        }
        return 0;
    }
}
