package com.imz.favourite_tags.network;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class FoodStatSyncPack {

    CompoundNBT nbtSource;

    public FoodStatSyncPack(PacketBuffer buffer){
        nbtSource = buffer.readCompoundTag();
    }
    public FoodStatSyncPack(CompoundNBT nbt){
        nbtSource = nbt;
    }

    public void toBytes(PacketBuffer buf){
        buf.writeCompoundTag(nbtSource);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx){
        ctx.get().enqueueWork(()->{
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.getFoodStats().read(nbtSource);
        });
        ctx.get().setPacketHandled(true);
    }
}
