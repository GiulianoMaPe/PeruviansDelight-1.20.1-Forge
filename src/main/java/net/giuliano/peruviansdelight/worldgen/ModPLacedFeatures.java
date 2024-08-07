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
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPLacedFeatures {
    public static final ResourceKey<PlacedFeature> PALTO_PLACED_KEY = registerKey("palto_placed");
    public static final ResourceKey<PlacedFeature> LIMONERO_PLACED_KEY = registerKey("limonero_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PALTO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALTO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.02f, 1),
                        ModBlocks.SEMILLA_PALTA.get()));    //TREES_PLAINS = (0, 0.05f, 1)
        register(context, LIMONERO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIMONERO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.02f, 1),
                        ModBlocks.SEMILLAS_LIMON.get()));   //p_195366_: Debe ser un número que al ser dividendo de uno no de un número largo.
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(PeruviansDelight.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
