package net.giuliano.peruviansdelight.compat.jei;

import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class TendalRecipeCategory implements IRecipeCategory<TendalRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(PeruviansDelight.MOD_ID, "tendal");
    public static final ResourceLocation TEXTURE = new ResourceLocation(PeruviansDelight.MOD_ID, "textures/gui/jei_tendal.png");

    private final IDrawable background;
    private final IDrawable icon;

    private final int altura = 146;
    private final int ancho = 60;

    public TendalRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, altura, ancho);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TENDAL.get()));
    }

    @Override
    public mezz.jei.api.recipe.RecipeType<TendalRecipe> getRecipeType() {
        return ModJEIPlugin.TENDAL_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.peruviansdelight.tendal");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TendalRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 21, 24)
                .addIngredients(recipe.input);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 119, 24)
                .addItemStack(recipe.output);
    }

    @Override
    public void draw(TendalRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        int processingTime = recipe.time;
        int seconds = processingTime / 20;
        Component timeString = Component.literal(seconds + "s");

        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        int stringWidth = font.width(timeString);

        int xPos = (altura - stringWidth - 2);
        int yPos = ancho - 10;

        guiGraphics.drawString(font, timeString, xPos, yPos, 0x8B8B8B, false);
    }
}