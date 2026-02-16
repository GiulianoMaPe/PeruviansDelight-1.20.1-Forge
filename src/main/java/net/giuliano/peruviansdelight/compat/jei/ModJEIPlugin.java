package net.giuliano.peruviansdelight.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.recipe.ModRecipes;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class ModJEIPlugin implements IModPlugin {
    // Definimos el TIPO de receta para JEI
    public static final RecipeType<TendalRecipe> TENDAL_TYPE =
            new RecipeType<>(TendalRecipeCategory.UID, TendalRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(PeruviansDelight.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TendalRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Minecraft.getInstance().level.getRecipeManager();

        // Obtenemos todas las recetas del tipo TENDAL y las registramos en JEI
        List<TendalRecipe> recipes = rm.getAllRecipesFor(ModRecipes.TENDAL_TYPE.get());
        registration.addRecipes(TENDAL_TYPE, recipes);
    }
}
