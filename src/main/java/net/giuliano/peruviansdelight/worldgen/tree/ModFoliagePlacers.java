package net.giuliano.peruviansdelight.worldgen.tree;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.worldgen.tree.custom.PaltoFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, PeruviansDelight.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<PaltoFoliagePlacer>> PALTO_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("palto_foliage_placer", () -> new FoliagePlacerType<>(PaltoFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
