package net.giuliano.peruviansdelight.recipe;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PeruviansDelight.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, PeruviansDelight.MOD_ID);

    public static final RegistryObject<RecipeSerializer<TendalRecipe>> TENDAL_SERIALIZER =
            SERIALIZERS.register("tendal", () -> TendalRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeType<TendalRecipe>> TENDAL_TYPE =
            TYPES.register("tendal", () -> TendalRecipe.Type.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}