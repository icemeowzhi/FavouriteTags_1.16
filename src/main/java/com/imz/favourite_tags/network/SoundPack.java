package com.imz.favourite_tags.network;

import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SoundPack {

    SoundEvent soundEvent;
    SoundCategory soundCategory;
    float volume;
    float pitch;



    public SoundPack(PacketBuffer buffer){
        soundEvent = buffer.readRegistryIdSafe(SoundEvent.class);
        soundCategory = buffer.readEnumValue(SoundCategory.class);
        volume = buffer.readFloat();
        pitch = buffer.readFloat();
    }

    public SoundPack( SoundEvent soundEvent, SoundCategory soundCategory, float volume, float pitch) {

        this.soundEvent = soundEvent;
        this.soundCategory = soundCategory;
        this.volume = volume;
        this.pitch = pitch;
    }

    public void toBytes(PacketBuffer buf){
        buf.writeRegistryId(soundEvent);
        buf.writeEnumValue(soundCategory);
        buf.writeFloat(volume);
        buf.writeFloat(pitch);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx){
        ctx.get().enqueueWork(()->{
            assert Minecraft.getInstance().player != null;
            Minecraft.getInstance().player.playSound(soundEvent,soundCategory,volume,pitch);
        });
        ctx.get().setPacketHandled(true);
    }

}
