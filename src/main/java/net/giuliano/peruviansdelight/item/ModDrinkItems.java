package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDrinkItems extends Item {
    public ModDrinkItems(Properties pProperties) {
        super(pProperties);
    }
    public static final DeferredRegister<Item> DRINK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PeruviansDelight.MOD_ID);

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public static void register(IEventBus eventBus) {
        DRINK_ITEMS.register(eventBus);
    }
}