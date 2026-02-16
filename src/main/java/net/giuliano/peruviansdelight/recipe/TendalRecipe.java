package net.giuliano.peruviansdelight.recipe;

import com.google.gson.JsonObject;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class TendalRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    public final Ingredient input;
    public final ItemStack output;
    public final int time;

    public TendalRecipe(ResourceLocation id, Ingredient input, ItemStack output, int time) {
        this.id = id;
        this.input = input;
        this.output = output;
        this.time = time;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        // Validación simple: revisa el primer slot (o cualquier slot que pasemos)
        // Como el bloque maneja la lógica de inserción, aquí solo validamos el ingrediente
        return input.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<TendalRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "tendal";
    }

    public static class Serializer implements RecipeSerializer<TendalRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(PeruviansDelight.MOD_ID, "tendal");

        @Override
        public TendalRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "ingredient"));
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
            int time = GsonHelper.getAsInt(pSerializedRecipe, "time");

            return new TendalRecipe(pRecipeId, input, output, time);
        }

        @Override
        public @Nullable TendalRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient input = Ingredient.fromNetwork(pBuffer);
            ItemStack output = pBuffer.readItem();
            int time = pBuffer.readInt();
            return new TendalRecipe(pRecipeId, input, output, time);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, TendalRecipe pRecipe) {
            pRecipe.input.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.output);
            pBuffer.writeInt(pRecipe.time);
        }
    }
}