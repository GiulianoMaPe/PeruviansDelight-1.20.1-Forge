package net.giuliano.peruviansdelight.item.custom;

import net.giuliano.peruviansdelight.item.ModDrinkItems;
import net.minecraft.world.item.ItemStack;

public class DrinkFoil extends ModDrinkItems {
    public DrinkFoil(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
