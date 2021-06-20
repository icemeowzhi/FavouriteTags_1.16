package com.imz.favourite_tags.capabilities;

import com.imz.favourite_tags.Utils.Constants;
import com.imz.favourite_tags.tag.FoodTagInitializer;
import com.imz.favourite_tags.tag.ITag;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CapabilityHandler {

    @CapabilityInject(IPlayerTagCapability.class)
    public static Capability<IPlayerTagCapability> PLAYER_TAG_CAPABILITY;

    @CapabilityInject(IFoodTagCapability.class)
    public static Capability<IFoodTagCapability> FOOD_TAG_CAPABILITY;

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    static class PreInit{
        @SubscribeEvent
        public static void registerCapabilityEvent(FMLCommonSetupEvent event){

            event.enqueueWork(() -> CapabilityManager.INSTANCE.register(
                    IPlayerTagCapability.class,
                    new Capability.IStorage<IPlayerTagCapability>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<IPlayerTagCapability> capability, IPlayerTagCapability instance, Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<IPlayerTagCapability> capability, IPlayerTagCapability instance, Direction side, INBT nbt) {

                        }
                    },
                    ()->null
            ));

            event.enqueueWork(() -> CapabilityManager.INSTANCE.register(
                    IFoodTagCapability.class,
                    new Capability.IStorage<IFoodTagCapability>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<IFoodTagCapability> capability, IFoodTagCapability instance, Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<IFoodTagCapability> capability, IFoodTagCapability instance, Direction side, INBT nbt) {

                        }
                    },
                    ()->null
            ));

        }
    }


    @Mod.EventBusSubscriber
    static class Init{
        @SubscribeEvent
        public static void onAttachCapabilityOnPlayerEvent(AttachCapabilitiesEvent<Entity> event) {
            Entity entity = event.getObject();
            if (entity instanceof PlayerEntity) {
                event.addCapability(new ResourceLocation(Constants.MODID, "player_tags"), new PlayerTagCapabilityProvider((PlayerEntity) entity));
            }
        }


        @SubscribeEvent
        public static void onAttachCapabilityOnItemStackEvent(AttachCapabilitiesEvent<ItemStack> event){
            ItemStack itemStack = event.getObject();

            for (Item item : FoodTagInitializer.tagMap.keySet()){
                if (itemStack.getItem().equals(item)){
                    FoodTagCapabilityProvider provider = new FoodTagCapabilityProvider(itemStack);
                    event.addCapability(new ResourceLocation(Constants.MODID,"food_tags"),provider);
                    FoodTagCapability foodTagCapability = (FoodTagCapability) provider.getOrCreateCapability(itemStack);
                    List<ITextComponent> tooltips = new ArrayList<>();
                    tooltips.add(new TranslationTextComponent("tag.tag_contains"));
                    for (ITag tag : foodTagCapability.getTags().getAllTags()){
                        tooltips.add(tag.getDisplayName());
                    }
                    item.addInformation(itemStack,null,tooltips, ITooltipFlag.TooltipFlags.NORMAL); //TODO
                }
            }
        }
    }


}
