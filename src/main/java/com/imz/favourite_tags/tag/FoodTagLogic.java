package com.imz.favourite_tags.tag;

import com.google.common.collect.Lists;
import com.imz.favourite_tags.capability.CapabilityHandler;
import com.imz.favourite_tags.hud.FeelingText;
import com.imz.favourite_tags.network.FeelingHudDisplayPack;
import com.imz.favourite_tags.network.FoodStatSyncPack;
import com.imz.favourite_tags.network.NetworkHandler;
import com.imz.favourite_tags.network.SoundPack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Mod.EventBusSubscriber
public class FoodTagLogic {
    private static ITags foodTags;
    private static ArrayList<ITags> playerTags;
    private static boolean isCoolDown = false;
    public static int nowCoolDown = 0;
    public static int coolDown = 6000;
    public static boolean badEffect = false;




    @SubscribeEvent
    public static void onUseItemStart(LivingEntityUseItemEvent.Start event){

        if (event.getEntity().getEntityWorld().isRemote){
            return;
        }

        if (event.getEntity() instanceof PlayerEntity){
            foodTags = null;
            playerTags = null;
            ItemStack itemStack = event.getItem();
            PlayerEntity player = (PlayerEntity) event.getEntity();
            itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).ifPresent((cap)-> foodTags = cap.getTags());
            player.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap)-> playerTags = cap.getAllTags());

            if(foodTags == null || playerTags == null){
                return;
            }

            for (ITag foodTag: foodTags.getAllTags()) {

                for (ITags tags:playerTags) {

                    for (ITag playerTag :tags.getAllTags()) {

                        if (foodTag.getRegistryName().equals(playerTag.getRegistryName())){

                            if (tags.getTagsGroup() == EnumTagGroup.FOODS_LIKE){

                                switch (playerTag.getTagRarity()){
                                    case EPIC:
                                        //进食速度增加100%
                                        event.setDuration((int) (event.getDuration()*0.5));

                                        //进食速度增加50%
                                        break; case UNCOMMON: case RARE: event.setDuration((int) (event.getDuration()*0.66));

                                        //进食速度增加30%
                                        break; default: event.setDuration((int) (event.getDuration()*0.77));
                                }


                            }else if (tags.getTagsGroup() == EnumTagGroup.FOODS_DISLIKE){

                                //进食速度降低50%
                                event.setDuration((int) (event.getDuration()*1.5));

                            }
                        }
                    }
                }
            }
        }
    }


    @SubscribeEvent
    public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event){

        if (event.getEntity().getEntityWorld().isRemote){
            return;
        }

        if (event.getEntity() instanceof PlayerEntity){

            ItemStack itemStack = event.getItem();
            PlayerEntity player = (PlayerEntity) event.getEntity();
            itemStack.getCapability(CapabilityHandler.FOOD_TAG_CAPABILITY).ifPresent((cap)-> foodTags = cap.getTags());
            player.getCapability(CapabilityHandler.PLAYER_TAG_CAPABILITY).ifPresent((cap)-> playerTags = cap.getAllTags());
            badEffect = false;

            if(foodTags == null || playerTags == null){
                return;
            }

            for (ITag foodTag: foodTags.getAllTags()) {

                for (ITags tags:playerTags) {

                    for (ITag playerTag :tags.getAllTags()) {

                        if (foodTag.getRegistryName().equals(playerTag.getRegistryName())){

                            Random random = new Random();
                            EffectInstance effectInstance;
                            if (tags.getTagsGroup() == EnumTagGroup.FOODS_LIKE){

                                switch (playerTag.getTagRarity()){
                                    case RARE:
                                        //回复额外50%饱食度
                                        player.getFoodStats().addStats(Objects.requireNonNull(itemStack.getItem().getFood()).getHealing()/2,
                                                itemStack.getItem().getFood().getSaturation()/2);

                                        NetworkHandler.INSTANCE.send(
                                                PacketDistributor.PLAYER.with(
                                                        () -> (ServerPlayerEntity) player
                                                ),
                                                new FeelingHudDisplayPack(Lists.newArrayList(FeelingText.getDefaultLike(false))));

                                        break; case EPIC:
                                        //回复额外50%饱食度
                                        //播放特殊音效
                                        player.getFoodStats().addStats(Objects.requireNonNull(itemStack.getItem().getFood()).getHealing()/2,
                                                itemStack.getItem().getFood().getSaturation()/2);

                                        //给予饱和效果或伤害吸收或幸运效果两分钟
                                        if (!isCoolDown){
                                            assert Minecraft.getInstance().world != null;

                                            NetworkHandler.INSTANCE.send(
                                                    PacketDistributor.PLAYER.with(
                                                            () -> (ServerPlayerEntity) player
                                                    ),
                                                    new SoundPack(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,SoundCategory.PLAYERS,1f,1f));

                                            switch (random.nextInt(4)){
                                                case 1:
                                                    effectInstance = new EffectInstance(Effects.SATURATION,
                                                            1000,0,false,true,true);

                                                    break; case 2: effectInstance = new EffectInstance(Effects.LUCK,
                                                        2400,1,false,true,true);

                                                    break; default: effectInstance = new EffectInstance(Effects.ABSORPTION,
                                                        2400,0,false,true,true);
                                            }
                                            player.addPotionEffect(effectInstance);

                                            //生命恢复效果一分钟
                                            player.addPotionEffect(new EffectInstance(Effects.REGENERATION,
                                                    1200,0,false,true,true));

                                            //cd五分钟
                                            isCoolDown = true;
                                            nowCoolDown = 0;

                                            NetworkHandler.INSTANCE.send(
                                                    PacketDistributor.PLAYER.with(
                                                            () -> (ServerPlayerEntity) player
                                                    ),
                                                    new FeelingHudDisplayPack(Lists.newArrayList(FeelingText.getDefaultLike(true))));

                                        }
                                        break;
                                    default:
                                        if (random.nextInt(4) == 1){

                                            NetworkHandler.INSTANCE.send(
                                                    PacketDistributor.PLAYER.with(
                                                            () -> (ServerPlayerEntity) player
                                                    ),
                                                    new FeelingHudDisplayPack(Lists.newArrayList(FeelingText.getDefaultLike(false))));
                                        }
                                }
                                //System.out.println("match and you like it, with rarity "+playerTag.getTagRarity().toString());
                            }else if (tags.getTagsGroup() == EnumTagGroup.FOODS_DISLIKE){

                                List<ITextComponent> messages = new ArrayList<>();

                                //有10%获得十秒反胃
                                if (random.nextInt(11) == 1){
                                    player.addPotionEffect(new EffectInstance(Effects.NAUSEA,
                                            200,1,false,true,true));
                                    badEffect = true;
                                }

                                //有30%不增加饱食度
                                if (random.nextInt(11) <= 3){
                                    if (!player.isCreative()){
                                        player.getFoodStats().addStats(-Objects.requireNonNull(itemStack.getItem().getFood()).getHealing(),0);

                                        CompoundNBT nbt = new CompoundNBT();
                                        player.getFoodStats().write(nbt);
                                        NetworkHandler.INSTANCE.send(
                                                PacketDistributor.PLAYER.with(
                                                        () -> (ServerPlayerEntity) player
                                                ),
                                                new FoodStatSyncPack(nbt));

                                        messages.add(FeelingText.getNonHealMessage());
                                    }
                                }

                                if (badEffect){
                                    messages.add(FeelingText.getDislike(true));
                                }else if (random.nextInt(4)==1){
                                    messages.add(FeelingText.getDislike(false));
                                }

                                //FeelingHud.INSTANCE.displayMessage(messages,100,255,255,255,255,40);

                                NetworkHandler.INSTANCE.send(
                                        PacketDistributor.PLAYER.with(
                                                () -> (ServerPlayerEntity) player
                                        ),
                                        new FeelingHudDisplayPack(messages));



                            }
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent event){
        if (isCoolDown){
            nowCoolDown++;
            if (nowCoolDown >= coolDown){
                isCoolDown = false;
            }
        }
    }
}
