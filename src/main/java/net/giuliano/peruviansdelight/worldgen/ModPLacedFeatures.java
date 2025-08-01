package net.giuliano.peruviansdelight.worldgen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPLacedFeatures {
    public static final ResourceKey<PlacedFeature> PALTO_PLACED_KEY = registerKey("palto_placed");
    public static final ResourceKey<PlacedFeature> LIMONERO_PLACED_KEY = registerKey("limonero_placed");
    public static final ResourceKey<PlacedFeature> AJI_AMARILLO_SILVESTRE_PLACED_KEY = registerKey("aji_amarillo_silvestre_placed");
    public static final ResourceKey<PlacedFeature> KION_SILVESTRE_PLACED_KEY = registerKey("kion_silvestre_placed");
    public static final ResourceKey<PlacedFeature> SOYA_SILVESTRE_PLACED_KEY = registerKey("soya_silvestre_placed");
    public static final ResourceKey<PlacedFeature> CAMOTE_SILVESTRE_PLACED_KEY = registerKey("camote_silvestre_placed");
    public static final ResourceKey<PlacedFeature> YUCA_SILVESTRE_PLACED_KEY = registerKey("yuca_silvestre_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PALTO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALTO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.02f, 2),
                        ModBlocks.SEMILLA_PALTA.get()));    //TREES_PLAINS = (0, 0.05f, 1)
        register(context, LIMONERO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIMONERO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.02f, 2),
                        ModBlocks.SEMILLAS_LIMON.get()));   //p_195366_: Debe ser un número que al ser dividendo de uno no de un número largo.

        register(context, AJI_AMARILLO_SILVESTRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AJI_AMARILLO_SILVESTRE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), // Frecuencia de generación normal
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.wouldSurvive(ModBlocks.AJI_AMARILLO_SILVESTRE.get().defaultBlockState(), net.minecraft.core.BlockPos.ZERO)),
                        BiomeFilter.biome()));
        register(context, KION_SILVESTRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KION_SILVESTRE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.wouldSurvive(ModBlocks.KION_SILVESTRE.get().defaultBlockState(), net.minecraft.core.BlockPos.ZERO)),
                        BiomeFilter.biome()));
        register(context, SOYA_SILVESTRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SOYA_SILVESTRE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.wouldSurvive(ModBlocks.SOYA_SILVESTRE.get().defaultBlockState(), net.minecraft.core.BlockPos.ZERO)),
                        BiomeFilter.biome()));
        register(context, CAMOTE_SILVESTRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAMOTE_SILVESTRE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.wouldSurvive(ModBlocks.CAMOTE_SILVESTRE.get().defaultBlockState(), net.minecraft.core.BlockPos.ZERO)),
                        BiomeFilter.biome()));
        register(context, YUCA_SILVESTRE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.YUCA_SILVESTRE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BlockPredicateFilter.forPredicate(net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate.wouldSurvive(ModBlocks.YUCA_SILVESTRE.get().defaultBlockState(), net.minecraft.core.BlockPos.ZERO)),
                        BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PeruviansDelight.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
