package net.giuliano.peruviansdelight.datagen.loot;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.block.custom.*;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    protected static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    protected static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

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

        LootItemCondition.Builder lootitemcondition$builder3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SOYA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoyaCropBlock.AGE, 7));
        this.add(ModBlocks.SOYA_CROP.get(), createModCropDrops(ModBlocks.SOYA_CROP.get(), ModItems.VAINA_SOYA.get(),
                ModItems.GRANOS_SOYA.get(), lootitemcondition$builder3));

        LootItemCondition.Builder lootitemcondition$builder4 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CAMOTE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CamoteCropBlock.AGE, 5));
        this.add(ModBlocks.CAMOTE_CROP.get(), createModCropDrops(ModBlocks.CAMOTE_CROP.get(), ModItems.CAMOTE.get(),
                ModItems.CAMOTE.get(), lootitemcondition$builder4));

        LootItemCondition.Builder lootitemcondition$builder5 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.YUCA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(YucaCropBlock.AGE, 4));
        this.add(ModBlocks.YUCA_CROP.get(), createModCropDrops(ModBlocks.YUCA_CROP.get(), ModItems.YUCA.get(),
                ModItems.YUCA.get(), lootitemcondition$builder5));

        this.add(ModBlocks.PALTA_LEAVES.get(), block ->
                createModLeavesDrops(block, ModItems.PALTA.get(), 1.0F, 1.25F, 1.6667F, 2.0F));
        this.add(ModBlocks.LIMON_LEAVES.get(), block ->
                createModLeavesDrops(block, ModItems.LIMON.get(), 1.0F, 1.25F, 1.6667F, 2.0F));

        this.dropSelf(ModBlocks.SEMILLA_PALTA.get());
        this.dropSelf(ModBlocks.SEMILLAS_LIMON.get());
    }

    protected LootTable.Builder createModLeavesDrops(Block pLeavesBlock, Item pSaplingBlock, float... pChances) {
        return createSilkTouchOrShearsDispatchTable(pLeavesBlock,
                this.applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(pSaplingBlock)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pChances)))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(this.applyExplosionDecay(pLeavesBlock, LootItem.lootTableItem(Items.STICK)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_STICK_CHANCES))));

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
