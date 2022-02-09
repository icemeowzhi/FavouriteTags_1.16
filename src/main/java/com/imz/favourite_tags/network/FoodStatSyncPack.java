package com.imz.favourite_tags.network;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.FoodStats;
import net.minecraftforge.fml.network.NetworkEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

/**
 * @author icemeowzhi
 * @date 2021/9/5
 * @apiNote
 */
public class FoodStatSyncPack {

    private static final Logger LOGGER = LogManager.getLogger();
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
            FoodStats foodStats = Minecraft.getInstance().player.getFoodStats();
            foodStats.read(nbtSource);
//            LOGGER.info("FoodStat synchronization complete.");
//            LOGGER.info("Now FoodStat:[hunger:{},saturation:{}]",foodStats.getFoodLevel(),foodStats.getSaturationLevel());
        });
        ctx.get().setPacketHandled(true);
    }
}
