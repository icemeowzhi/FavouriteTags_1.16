package com.imz.favourite_tags.hud;

import com.google.common.collect.Lists;
import com.imz.favourite_tags.util.ARGBColor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class FeelingHud extends AbstractGui {
    public static final FeelingHud INSTANCE = new FeelingHud();
    private int width;
    private int height;
    private final Minecraft minecraft;
    private List<ITextComponent> displayedMessage = Lists.newArrayList(new StringTextComponent(""));
    private static boolean displayed = false;
    private int duration = 0;
    private static int time = 0;
    private int r = 0;
    private int g = 0;
    private int b = 0;
    private int maxAlpha = 0;
    private int alpha = 4;
    private int gradientTime;

    public FeelingHud(){
        this.width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        this.height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        this.minecraft = Minecraft.getInstance();
    }

    public void render(MatrixStack matrixStack){
        if (!displayed) return;
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        height = Minecraft.getInstance().getMainWindow().getScaledHeight();
        if (time <duration){

            //渐变效果
            if (time <= gradientTime){

                if (alpha < (255-(maxAlpha/gradientTime))){
                    alpha += maxAlpha/gradientTime;
                }else alpha = 255;

            }else if (time >= duration-gradientTime){

                if (alpha > (maxAlpha/gradientTime)){
                    alpha -= maxAlpha/gradientTime;
                }else alpha = 4;

            }
            int renderY = height-50;
            for (ITextComponent message : displayedMessage){
                IReorderingProcessor ireorderingprocessor = message.func_241878_f();
                minecraft.fontRenderer.func_238422_b_(matrixStack,ireorderingprocessor,
                        (float)((width)/2 - minecraft.fontRenderer.func_243245_a(ireorderingprocessor)/2), //(float)((width)/2 - minecraft.fontRenderer.func_243245_a(ireorderingprocessor)/2 )
                        (float) renderY, ARGBColor.toInt(r,g,b,alpha));
                renderY-=12;
            }


        }else {displayed = false;}

    }

    public void displayMessage(List<ITextComponent> messages, int duration, int r , int g , int b , int maxAlpha){
        this.r = r;
        this.g = g;
        this.b = b;
        displayed = true;
        displayedMessage = messages;
        this.duration = duration;
        time = 0;
        this.maxAlpha = maxAlpha;
        gradientTime = 20;
    }

    public void displayMessage(List<ITextComponent> messages, int duration, int r , int g , int b , int maxAlpha , int gradientTime){
        this.r = r;
        this.g = g;
        this.b = b;
        displayed = true;
        displayedMessage = messages;
        this.duration = duration;
        time = 0;
        this.maxAlpha = maxAlpha;
        this.gradientTime = gradientTime;
    }

    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent event){
        if (!displayed) return;
        time++;
    }
}

