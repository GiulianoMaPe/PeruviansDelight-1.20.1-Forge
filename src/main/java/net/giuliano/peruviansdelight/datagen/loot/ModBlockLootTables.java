package net.giuliano.peruviansdelight.datagen.loot;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.block.custom.AjiAmarilloCropBlock;
import net.giuliano.peruviansdelight.block.custom.KionCropBlock;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.CARA.get(),
                block -> createCopperLikeOreDrops(ModBlocks.CARA.get(), ModItems.ALMA_EN_PENA.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.AJI_AMARILLO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AjiAmarilloCropBlock.AGE, 7));
        this.add(ModBlocks.AJI_AMARILLO_CROP.get(), createModCropDrops(ModBlocks.AJI_AMARILLO_CROP.get(), ModItems.AJI_AMARILLO.get(),
                ModItems.SEMILLAS_AJI_AMARILLO.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.KION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(KionCropBlock.AGE, 4));
        this.add(ModBlocks.KION_CROP.get(), createModCropDrops(ModBlocks.KION_CROP.get(), ModItems.KION.get(),
                ModItems.KION.get(), lootitemcondition$builder2));
    }

    protected LootTable.Builder createModCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return this.applyExplosionDecay(pCropBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pSeedsItem)
                                .when(pDropGrownCropCondition)
                                .otherwise(LootItem.lootTableItem(pSeedsItem))))
                .withPool(LootPool.lootPool()
                        .when(pDropGrownCropCondition)
                        .add(LootItem.lootTableItem(pGrownCropItem)
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 2)))));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
