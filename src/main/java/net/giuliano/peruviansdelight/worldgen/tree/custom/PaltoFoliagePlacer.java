package net.giuliano.peruviansdelight.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.giuliano.peruviansdelight.worldgen.tree.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PaltoFoliagePlacer extends FoliagePlacer {
    public static final Codec<PaltoFoliagePlacer> CODEC = RecordCodecBuilder.create(paltoFoliagePlacerInstance
            -> foliagePlacerParts(paltoFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
                    .forGetter(fp -> fp.altura)).apply(paltoFoliagePlacerInstance, PaltoFoliagePlacer::new));

    private final int altura;

    public PaltoFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int pAltura) {
        super(pRadius, pOffset);
        this.altura = pAltura;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.PALTO_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        /*
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-2), 1, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(-1), 2, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0), 2, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(1), 2, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(2), 1, 0, pAttachment.doubleTrunk());
        */
        for (int i = pOffset; i >= pOffset - pFoliageHeight; --i) {
            int radius = Math.max(pFoliageRadius + pAttachment.radiusOffset() - 1 - i / 2, 0);
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), radius, i, pAttachment.doubleTrunk());
        }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.altura;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return pLocalX == pRange && pLocalZ == pRange && (pRandom.nextInt(2) == 0 || pLocalY == 0);
    }
}
