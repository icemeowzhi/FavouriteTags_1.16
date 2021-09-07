package com.imz.favourite_tags.network;

import com.imz.favourite_tags.capability.CapabilityHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
public class PlayerTagCapPack {

    CompoundNBT nbtSource;

    public PlayerTagCapPack(PacketBuffer buffer){
        nbtSource = buffer.readCompoundTag();
    }
    public PlayerTagCapPack(CompoundNBT nbt){
        nbtSource = nbt;
    }

    public void toBytes(PacketBuffer buf){
        buf.writeCompoundTag(nbtSource);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx){
        ctx.get().enqueueWork(()->{
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap)->cap.deserializeNBT(nbtSource));
        });
        ctx.get().setPacketHandled(true);
    }
}
