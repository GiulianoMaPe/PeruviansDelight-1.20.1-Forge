package net.giuliano.peruviansdelight.datagen;

import com.google.gson.JsonObject;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.recipe.ModRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    private static final TagKey<Item> FORGE_BREAD = ItemTags.create(new ResourceLocation("forge", "bread"));
    private static final TagKey<Item> FORGE_MILK = ItemTags.create(new ResourceLocation("forge", "milk"));

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // RECETAS DE CRAFTING
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIMONERO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.LIMONERO_LOG.get())
                .unlockedBy("has_limonero_log", has(ModBlocks.LIMONERO_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_LIMONERO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.STRIPPED_LIMONERO_LOG.get())
                .unlockedBy("has_stripped_limonero_log", has(ModBlocks.STRIPPED_LIMONERO_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PALTO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.PALTO_LOG.get())
                .unlockedBy("has_palto_log", has(ModBlocks.PALTO_LOG.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_PALTO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.STRIPPED_PALTO_LOG.get())
                .unlockedBy("has_stripped_palto_log", has(ModBlocks.STRIPPED_PALTO_LOG.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIMONERO_PLANKS.get(), 4)
                .requires(Ingredient.of(ModBlocks.LIMONERO_LOG.get(), ModBlocks.LIMONERO_WOOD.get(), ModBlocks.STRIPPED_LIMONERO_LOG.get(), ModBlocks.STRIPPED_LIMONERO_WOOD.get()))
                .unlockedBy("has_limonero_log", has(ModBlocks.LIMONERO_LOG.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PALTO_PLANKS.get(), 4)
                .requires(Ingredient.of(ModBlocks.PALTO_LOG.get(), ModBlocks.PALTO_WOOD.get(), ModBlocks.STRIPPED_PALTO_LOG.get(), ModBlocks.STRIPPED_PALTO_WOOD.get()))
                .unlockedBy("has_limonero_log", has(ModBlocks.PALTO_LOG.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING, 4)
                .requires(ItemTags.WOOL)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(pWriter);

        // CRATES
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AJI_AMARILLO_CRATE.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.AJI_AMARILLO.get())
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AJI_AMARILLO.get(), 9)
                .requires(ModBlocks.AJI_AMARILLO_CRATE.get())
                .unlockedBy("has_aji_amarillo_crate", has(ModBlocks.AJI_AMARILLO_CRATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CAMOTE_CRATE.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.CAMOTE.get())
                .unlockedBy("has_camote", has(ModItems.CAMOTE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CAMOTE.get(), 9)
                .requires(ModBlocks.CAMOTE_CRATE.get())
                .unlockedBy("has_camote_crate", has(ModBlocks.CAMOTE_CRATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KION_CRATE.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.KION.get())
                .unlockedBy("has_kion", has(ModItems.KION.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KION.get(), 9)
                .requires(ModBlocks.KION_CRATE.get())
                .unlockedBy("has_kion_crate", has(ModBlocks.KION_CRATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIMON_CRATE.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.LIMON.get())
                .unlockedBy("has_limon", has(ModItems.LIMON.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIMON.get(), 9)
                .requires(ModBlocks.LIMON_CRATE.get())
                .unlockedBy("has_limon_crate", has(ModBlocks.LIMON_CRATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PALTA_CRATE.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.PALTA.get())
                .unlockedBy("has_palta", has(ModItems.PALTA.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PALTA.get(), 9)
                .requires(ModBlocks.PALTA_CRATE.get())
                .unlockedBy("has_palta_crate", has(ModBlocks.PALTA_CRATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOYA_CRATE.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.VAINA_SOYA.get())
                .unlockedBy("has_vaina_soya", has(ModItems.VAINA_SOYA.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VAINA_SOYA.get(), 9)
                .requires(ModBlocks.SOYA_CRATE.get())
                .unlockedBy("has_soya_crate", has(ModBlocks.SOYA_CRATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YUCA_CRATE.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.YUCA.get())
                .unlockedBy("has_yuca", has(ModItems.YUCA.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.YUCA.get(), 9)
                .requires(ModBlocks.YUCA_CRATE.get())
                .unlockedBy("has_yuca_crate", has(ModBlocks.YUCA_CRATE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOYA_BAG.get())
                .pattern("SSS").pattern("SSS").pattern("SSS")
                .define('S', ModItems.GRANOS_SOYA.get())
                .unlockedBy("has_granos_soya", has(ModItems.GRANOS_SOYA.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANOS_SOYA.get(), 9)
                .requires(ModBlocks.SOYA_BAG.get())
                .unlockedBy("has_soya_bag", has(ModBlocks.SOYA_BAG.get()))
                .save(pWriter, "granos_soya_from_soya_bag");

        // COMIDAS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MOSTRITO.get(), 2)
                .requires(ModItems.POLLO_BRASA.get())
                .requires(ModItems.CHAUFA.get())
                .unlockedBy("has_pollo_brasa", has(ModItems.POLLO_BRASA.get()))
                .unlockedBy("has_chaufa", has(ModItems.CHAUFA.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANOS_SOYA.get(), 2)
                .requires(ModItems.VAINA_SOYA.get())
                .unlockedBy("has_vaina_soya", has(ModItems.VAINA_SOYA.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HUANCAINA.get(), 2)
                .requires(Items.BOWL)
                .requires(Ingredient.of(ModItems.AJI_AMARILLO.get(), ModItems.POTE_AJI_AMARILLO.get()))
                .requires(FORGE_BREAD)
                .requires(FORGE_MILK)
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POTE_AJI_AMARILLO.get(), 2)
                .pattern("#S#")
                .define('#', Items.GLASS_BOTTLE)
                .define('S', ModItems.AJI_AMARILLO.get())
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ANTICUCHO.get())
                .requires(ModItems.RAW_HEART_SLICES.get())
                .requires(Items.STICK)
                .unlockedBy("has_raw_heart_slices", has(ModItems.RAW_HEART_SLICES.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SEMILLAS_AJI_AMARILLO.get())
                .requires(ModItems.AJI_AMARILLO.get())
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILLAO.get())
                .requires(ModItems.GRANOS_SOYA.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_granos_soya", has(ModItems.GRANOS_SOYA.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SEMILLAS_LIMON.get())
                .requires(ModItems.LIMON.get())
                .unlockedBy("has_limon", has(ModItems.LIMON.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SEMILLA_PALTA.get())
                .requires(ModItems.PALTA.get())
                .unlockedBy("has_palta", has(ModItems.PALTA.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MUD_TILES.get(), 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', Blocks.MUD_BRICKS)
                .unlockedBy("has_mud_bricks", has(Blocks.MUD_BRICKS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_MUD_TILES.get(), 2)
                .pattern("S")
                .pattern("S")
                .define('S', ModBlocks.MUD_TILES.get())
                .unlockedBy("has_mud_tiles", has(ModBlocks.MUD_TILES.get()))
                .save(pWriter);

        // CORTADORA DE PIEDRA
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.MUD_TILES.get(), Blocks.MUD_BRICKS);
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.CHISELED_MUD_TILES.get(), Blocks.MUD_BRICKS);
        stonecutterResultFromBase(pWriter, RecipeCategory.MISC, ModBlocks.CHISELED_MUD_TILES.get(), ModBlocks.MUD_TILES.get());

        // COCCION DE INGREDIENTES
        createFoodCookingRecipes(pWriter, ModItems.RAW_ANTICUCHO.get(), ModItems.ANTICUCHO.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.CAMOTE.get(), ModItems.CAMOTE_COCIDO.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.CAMOTE_CORTADO.get(), ModItems.CAMOTE_FRITO.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.POTA_CORTADO.get(), ModItems.CHICHARRON_POTA.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.FILETE_ATUN.get(), ModItems.FILETE_ATUN_COCIDO.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.PAPAS_CORTADAS.get(), ModItems.PAPAS_FRITAS.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.YUCA_CORTADA.get(), ModItems.YUCA_FRITA.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.CHULETA_CORTADA.get(), ModItems.CHICHARRON.get(), 0.35f);
        createFoodCookingRecipes(pWriter, ModItems.LLAMA.get(), ModItems.LLAMA_ASADA.get(), 0.35f);

        // TENDAL
        buildTendalRecipe(pWriter, ModItems.LLAMA.get(), ModItems.CHARQUI.get(), 9600, "charqui_from_tendal"); // 8 min //20 ticks = 1 segundo
        buildTendalRecipe(pWriter, Items.MUTTON, ModItems.CHARQUI.get(), 9600, "mutton_charqui_from_tendal");

        // MADERA
        stairBuilder(ModBlocks.LIMONERO_STAIRS.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMONERO_SLAB.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);
        buttonBuilder(ModBlocks.LIMONERO_BUTTON.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.LIMONERO_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);
        fenceBuilder(ModBlocks.LIMONERO_FENCE.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);
        fenceGateBuilder(ModBlocks.LIMONERO_FENCE_GATE.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);
        doorBuilder(ModBlocks.LIMONERO_DOOR.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);
        trapdoorBuilder(ModBlocks.LIMONERO_TRAPDOOR.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS.get())).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS.get()))
                .save(pWriter);

        stairBuilder(ModBlocks.PALTO_STAIRS.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALTO_SLAB.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
        buttonBuilder(ModBlocks.PALTO_BUTTON.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.PALTO_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
        fenceBuilder(ModBlocks.PALTO_FENCE.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
        fenceGateBuilder(ModBlocks.PALTO_FENCE_GATE.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
        doorBuilder(ModBlocks.PALTO_DOOR.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
        trapdoorBuilder(ModBlocks.PALTO_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALTO_PLANKS.get())).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS.get()))
                .save(pWriter);
    }

    protected static void createFoodCookingRecipes(Consumer<FinishedRecipe> pWriter, ItemLike input, ItemLike output, float experience) {
        int smeltingTime = 200;
        int smokingTime = 100;
        int campfireTime = 600;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, experience, smeltingTime)
                .unlockedBy(getHasName(input), has(input))
                .save(pWriter, getItemName(output) + "_from_smelting");

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, experience, smokingTime)
                .unlockedBy(getHasName(input), has(input))
                .save(pWriter, getItemName(output) + "_from_smoking");

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, experience, campfireTime)
                .unlockedBy(getHasName(input), has(input))
                .save(pWriter, getItemName(output) + "_from_campfire_cooking");
    }

    protected void buildTendalRecipe(Consumer<FinishedRecipe> consumer, ItemLike input, ItemLike output, int time, String name) {
        // 1. Convertimos el ItemLike (Item o Bloque) a Ingredient aquí mismo
        Ingredient ingrediente = Ingredient.of(input);

        // 2. Generamos el ID de la receta
        ResourceLocation id = new ResourceLocation(PeruviansDelight.MOD_ID, name);

        // 3. Creamos el Advancement (Logro invisible) para que la receta se desbloquee al tener el ítem
        Advancement.Builder advancement = Advancement.Builder.advancement()
                .addCriterion("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .parent(new ResourceLocation("recipes/root"))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(RequirementsStrategy.OR);

        // 4. Guardamos la receta usando el Builder
        consumer.accept(new TendalRecipeBuilder(
                id,
                ingrediente, // Pasamos el ingrediente convertido
                output,
                time,
                advancement,
                new ResourceLocation(PeruviansDelight.MOD_ID, "recipes/misc/" + name)
        ));
    }

    protected static class TendalRecipeBuilder implements FinishedRecipe {
        private final ResourceLocation id;
        private final Ingredient input;
        private final Item result;
        private final int time;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public TendalRecipeBuilder(ResourceLocation id, Ingredient input, ItemLike result, int time, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.input = input;
            this.result = result.asItem();
            this.time = time;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            json.add("ingredient", input.toJson());

            JsonObject resultObj = new JsonObject();
            resultObj.addProperty("item", ForgeRegistries.ITEMS.getKey(result).toString());
            json.add("result", resultObj);

            json.addProperty("time", time);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipes.TENDAL_SERIALIZER.get();
        }

        @Override
        public JsonObject serializeAdvancement() {
            return advancement.serializeToJson();
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return advancementId;
        }
    }
}