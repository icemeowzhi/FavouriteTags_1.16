package com.imz.favourite_tags.capability;

import com.imz.favourite_tags.FavouriteTag;
import com.imz.favourite_tags.capability.food_tag_capability.FoodTagCapabilityProvider;
import com.imz.favourite_tags.capability.food_tag_capability.IFoodTagCapability;
import com.imz.favourite_tags.capability.player_fed_up_capability.IPlayerFedUpCapability;
import com.imz.favourite_tags.capability.player_fed_up_capability.PlayerFedUpCapabilityProvider;
import com.imz.favourite_tags.capability.player_tag_capability.IPlayerTagCapability;
import com.imz.favourite_tags.capability.player_tag_capability.PlayerTagCapabilityProvider;
import com.imz.favourite_tags.intance.TaggedFoodInitializer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author icemeowzhi
 * @date 2021/9/4
 * @apiNote
 */
public class CapabilityHandler {

    @CapabilityInject(IPlayerTagCapability.class)
    public static Capability<IPlayerTagCapability> PLAYER_TAG_CAPABILITY;

    @CapabilityInject(IFoodTagCapability.class)
    public static Capability<IFoodTagCapability> FOOD_TAG_CAPABILITY;

    @CapabilityInject(IPlayerFedUpCapability.class)
    public static Capability<IPlayerFedUpCapability> PLAYER_FED_UP_CAPABILITY;

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD,modid = FavouriteTag.MODID)
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

            event.enqueueWork(() -> CapabilityManager.INSTANCE.register(
                    IPlayerFedUpCapability.class,
                    new Capability.IStorage<IPlayerFedUpCapability>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<IPlayerFedUpCapability> capability, IPlayerFedUpCapability instance, Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<IPlayerFedUpCapability> capability, IPlayerFedUpCapability instance, Direction side, INBT nbt) {

                        }
                    },
                    ()->null
            ));

        }
    }


    @Mod.EventBusSubscriber(modid = FavouriteTag.MODID)
    static class Init{
        @SubscribeEvent
        public static void onAttachCapabilityOnPlayerEvent(AttachCapabilitiesEvent<Entity> event) {
            Entity entity = event.getObject();
            if (entity instanceof PlayerEntity) {
                event.addCapability(new ResourceLocation(FavouriteTag.MODID,"player_fed_up"),new PlayerFedUpCapabilityProvider((PlayerEntity) entity));
                event.addCapability(new ResourceLocation(FavouriteTag.MODID, "player_tags"), new PlayerTagCapabilityProvider((PlayerEntity) entity));
            }
        }

        @SubscribeEvent
        public static void onAttachCapabilityOnItemStackEvent(@Nonnull AttachCapabilitiesEvent<ItemStack> event){
            ItemStack itemStack = event.getObject();

            for (Item item : TaggedFoodInitializer.getFoodTagMap().keySet()){
                if (itemStack.getItem().equals(item)){
                    FoodTagCapabilityProvider provider = new FoodTagCapabilityProvider(itemStack);
                    event.addCapability(new ResourceLocation(FavouriteTag.MODID,"food_tags"),provider);
                }
            }
        }
    }


}
