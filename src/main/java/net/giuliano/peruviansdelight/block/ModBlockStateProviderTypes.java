package net.giuliano.peruviansdelight.block;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.worldgen.tree.RandomLeafBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProviderTypes {
    public static final DeferredRegister<BlockStateProviderType<?>> BLOCK_STATE_PROVIDERS =
            DeferredRegister.create(Registries.BLOCK_STATE_PROVIDER_TYPE, PeruviansDelight.MOD_ID);

    public static final RegistryObject<BlockStateProviderType<RandomLeafBlockStateProvider>> RANDOM_LEAF_PROVIDER =
            BLOCK_STATE_PROVIDERS.register("random_leaf_provider", () ->
                    new BlockStateProviderType<>(RandomLeafBlockStateProvider.CODEC));
}
