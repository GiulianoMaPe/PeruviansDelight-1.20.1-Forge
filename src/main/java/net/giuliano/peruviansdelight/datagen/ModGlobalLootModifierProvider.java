package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.loot.AddItemModifier;
import net.giuliano.peruviansdelight.loot.AddRandomCountItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider  extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, PeruviansDelight.MOD_ID);
    }

    @Override
    protected void start() {
        /*
        //Modificar loot de Bloques
        add("inka_for_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()
        }, ModItems.INCA_KOLA.get()));
        */

        // MOBS
        add("lana_from_llama_x_color", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/llama")).build()
        }));
        add("lana_from_trader_llama_x_color", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/trader_llama")).build()
        }));

        add("pota_for_calamar", new AddRandomCountItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/squid")).build()
        }, ModItems.TENTACULO_POTA.get(), 6, 8, false));
        add("pota_for_glow_calamar", new AddRandomCountItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/glow_squid")).build()
        }, ModItems.TENTACULO_POTA.get(), 6, 8, false));

        add("llama_meat_from_llama", new AddRandomCountItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/llama")).build()
        }, ModItems.LLAMA.get(), 1, 3, true));
        add("llama_meat_from_trader_llama", new AddRandomCountItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/trader_llama")).build()
        }, ModItems.LLAMA.get(), 1, 3, true));

        // COFRES
        add("inka_for_chest1", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/pillager_outpost")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest2", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest3", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest4", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/stronghold_library")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest5", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest6", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest7", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/igloo_chest")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest8", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/buried_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest9", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest10", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest11", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest12", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest13", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_armorer")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest14", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_butcher")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest15", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest16", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest17", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/woodland_mansion")).build(),
                LootItemRandomChanceCondition.randomChance(0.50f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest18", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/underwater_ruin_big")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build(),
        }, ModItems.INCA_KOLA.get()));

        add("inka_for_chest19", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/underwater_ruin_small")).build(),
                LootItemRandomChanceCondition.randomChance(0.10f).build(),
        }, ModItems.INCA_KOLA.get()));
    }
}
