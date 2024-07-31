package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
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

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        ItemStack emptyBottle = new ItemStack(Items.GLASS_BOTTLE);

        if (!world.isClientSide) {
            if (stack.isEmpty()) {
                return emptyBottle;
            } else {
                if (entity instanceof Player) {
                    Player player = (Player) entity;
                    if (!player.getInventory().add(emptyBottle)) {
                        player.drop(emptyBottle, false);
                    }
                }
            }
        }

        return super.finishUsingItem(stack, world, entity);
    }

    public static void register(IEventBus eventBus) {
        DRINK_ITEMS.register(eventBus);
    }
}