package net.giuliano.peruviansdelight.worldgen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.worldgen.tree.RandomLeafBlockStateProvider;
import net.giuliano.peruviansdelight.worldgen.tree.custom.PaltoFoliagePlacer;
import net.giuliano.peruviansdelight.worldgen.tree.custom.PaltoTrunkPLacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockPileConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALTO_KEY = registerKey("palto");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMONERO_KEY = registerKey("limonero");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AJI_AMARILLO_SILVESTRE_KEY = registerKey("aji_amarillo_silvestre");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KION_SILVESTRE_KEY = registerKey("kion_silvestre");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SOYA_SILVESTRE_KEY = registerKey("soya_silvestre");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAMOTE_SILVESTRE_KEY = registerKey("camote_silvestre");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YUCA_SILVESTRE_KEY = registerKey("yuca_silvestre");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, PALTO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new PaltoTrunkPLacer(3, 1, 1),

                new RandomLeafBlockStateProvider(List.of(
                        BlockStateProvider.simple(ModBlocks.PALTO_LEAVES.get()),
                        BlockStateProvider.simple(ModBlocks.PALTO_LEAVES_EMPTY.get())
                )),
                new PaltoFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0,2)).build());

        register(context, LIMONERO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new PaltoTrunkPLacer(3, 1, 1),

                new RandomLeafBlockStateProvider(List.of(
                        BlockStateProvider.simple(ModBlocks.LIMONERO_LEAVES.get()),
                        BlockStateProvider.simple(ModBlocks.LIMONERO_LEAVES_EMPTY.get())
                )),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0,2)).build());

        register(context, AJI_AMARILLO_SILVESTRE_KEY, Feature.BLOCK_PILE, new BlockPileConfiguration(
                BlockStateProvider.simple(ModBlocks.AJI_AMARILLO_SILVESTRE.get())));
        register(context, KION_SILVESTRE_KEY, Feature.BLOCK_PILE, new BlockPileConfiguration(
                BlockStateProvider.simple(ModBlocks.KION_SILVESTRE.get())));
        register(context, SOYA_SILVESTRE_KEY, Feature.BLOCK_PILE, new BlockPileConfiguration(
                BlockStateProvider.simple(ModBlocks.SOYA_SILVESTRE.get())));
        register(context, CAMOTE_SILVESTRE_KEY, Feature.BLOCK_PILE, new BlockPileConfiguration(
                BlockStateProvider.simple(ModBlocks.CAMOTE_SILVESTRE.get())));
        register(context, YUCA_SILVESTRE_KEY, Feature.BLOCK_PILE, new BlockPileConfiguration(
                BlockStateProvider.simple(ModBlocks.YUCA_SILVESTRE.get())));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(PeruviansDelight.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}