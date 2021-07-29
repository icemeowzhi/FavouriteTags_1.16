package com.imz.favourite_tags.network;

import com.imz.favourite_tags.hud.FeelingHud;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FeelingHudDisplayPack {

    List<ITextComponent> messages;
    int messageCount;
    int duration;
    int r;int g;int b;
    int maxAlpha;
    int gradientTime;

    public FeelingHudDisplayPack(PacketBuffer buffer){
        messageCount = buffer.readInt();
        messages = new ArrayList<>();
        for (int i = 0; i < messageCount; i++) {
            messages.add(buffer.readTextComponent());
        }
        duration = buffer.readInt();
        r=buffer.readInt();
        g=buffer.readInt();
        b=buffer.readInt();
        maxAlpha=buffer.readInt();
        gradientTime=buffer.readInt();
    }

    public FeelingHudDisplayPack(List<ITextComponent> messages){
        messageCount = messages.size();
        this.messages = messages;
        duration = 100;
        r=255;g=255;b=255;
        maxAlpha = 255;
        gradientTime = 40;
    }


    public FeelingHudDisplayPack(List<ITextComponent> messages, int duration, int r, int g, int b, int maxAlpha, int gradientTime) {
        messageCount = messages.size();
        this.messages = messages;
        this.duration = duration;
        this.r = r;
        this.g = g;
        this.b = b;
        this.maxAlpha = maxAlpha;
        this.gradientTime = gradientTime;
    }

    public void toBytes(PacketBuffer buf){
        buf.writeInt(messageCount);
        for (ITextComponent message:messages) {
            buf.writeTextComponent(message);
        }
        buf.writeInt(duration);
        buf.writeInt(r);
        buf.writeInt(g);
        buf.writeInt(b);
        buf.writeInt(maxAlpha);
        buf.writeInt(gradientTime);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx){
        ctx.get().enqueueWork(()->{
            FeelingHud.INSTANCE.displayMessage(messages,duration,r,g,b,maxAlpha,gradientTime);
            for (ITextComponent message:
                 messages) {
                System.out.println(message.getString());
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
