package net.giuliano.peruviansdelight.worldgen.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.giuliano.peruviansdelight.block.ModBlockStateProviderTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

import java.util.List;

public class RandomLeafBlockStateProvider extends BlockStateProvider {
    // Código para serializar/deserializar esta clase
    public static final Codec<RandomLeafBlockStateProvider> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(BlockStateProvider.CODEC).fieldOf("providers").forGetter(p -> p.providers)
            ).apply(instance, RandomLeafBlockStateProvider::new)
    );

    private final List<BlockStateProvider> providers;

    public RandomLeafBlockStateProvider(List<BlockStateProvider> providers) {
        this.providers = providers;
    }

    @Override
    protected BlockStateProviderType<?> type() {
        // Registra este tipo en tu mod (ver más abajo)
        return ModBlockStateProviderTypes.RANDOM_LEAF_PROVIDER.get();
    }

    @Override
    public BlockState getState(RandomSource random, net.minecraft.core.BlockPos pos) {
        // Selecciona aleatoriamente uno de los proveedores
        int index = random.nextInt(providers.size());
        return providers.get(index).getState(random, pos);
    }
}