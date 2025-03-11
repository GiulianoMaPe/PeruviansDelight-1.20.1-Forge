package net.giuliano.peruviansdelight.worldgen.tree;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.worldgen.tree.custom.PaltoTrunkPLacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, PeruviansDelight.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<PaltoTrunkPLacer>> PALTO_TRUNK_PLACER =
            TRUNK_PLACER.register("palto_trunk_placer", () -> new TrunkPlacerType<>(PaltoTrunkPLacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
