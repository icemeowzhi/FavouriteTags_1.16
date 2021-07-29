package com.imz.favourite_tags.hud;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.Random;

public class FeelingText {

    private static final Random random = new Random();

    public static ITextComponent getDefaultLike(boolean isEpic){

        if (isEpic){
            return new TranslationTextComponent("feeling.like.epic");
        }   else {
            TranslationTextComponent message;
            switch (random.nextInt(6)){
                case 1:
                    message = new TranslationTextComponent("feeling.like.message1");
                    break;
                case 2:
                    message = new TranslationTextComponent("feeling.like.message2");
                    break;
                case 3:
                    message = new TranslationTextComponent("feeling.like.message3");
                    break;
                case 4:
                    message = new TranslationTextComponent("feeling.like.message4");
                    break;
                default:
                    message = new TranslationTextComponent("feeling.like.message5");
            }
            return message;
        }

    }

    public static ITextComponent getDislike(boolean isEffected){

        if (isEffected){

            if (random.nextInt(3) == 1){
                return new TranslationTextComponent("feeling.dislike.effected1");
            }else {
                return new TranslationTextComponent("feeling.dislike.effected2");
            }

        } else {
            TranslationTextComponent message;
            switch (random.nextInt(6)){
                case 1:
                    message = new TranslationTextComponent("feeling.dislike.message1");
                    break;
                case 2:
                    message = new TranslationTextComponent("feeling.dislike.message2");
                    break;
                case 3:
                    message = new TranslationTextComponent("feeling.dislike.message3");
                    break;
                case 4:
                    message = new TranslationTextComponent("feeling.dislike.message4");
                    break;
                default:
                    message = new TranslationTextComponent("feeling.dislike.message5");
            }
            return message;
        }

    }

    public static ITextComponent getNonHealMessage(){return new TranslationTextComponent("feeling.dislike.noheal");}
}
