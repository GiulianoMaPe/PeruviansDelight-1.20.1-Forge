package net.giuliano.peruviansdelight.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.giuliano.peruviansdelight.worldgen.tree.ModTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class PaltoTrunkPLacer extends TrunkPlacer {
    public static final Codec<PaltoTrunkPLacer> CODEC = RecordCodecBuilder.create((paltoTrunkPLacerInstance) ->
            trunkPlacerParts(paltoTrunkPLacerInstance).apply(paltoTrunkPLacerInstance, PaltoTrunkPLacer::new));

    public PaltoTrunkPLacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PALTO_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter,
                                                            RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int altura = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 2);

        for(int i = 0; i < altura; i++) {
           placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(altura), 0, false));
    }
}
