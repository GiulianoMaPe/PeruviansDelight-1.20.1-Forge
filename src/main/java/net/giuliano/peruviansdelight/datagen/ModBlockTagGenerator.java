package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PeruviansDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALTO_LOG.get())
                .add(ModBlocks.PALTO_WOOD.get())
                .add(ModBlocks.STRIPPED_PALTO_LOG.get())
                .add(ModBlocks.STRIPPED_PALTO_WOOD.get())
                .add(ModBlocks.LIMONERO_LOG.get())
                .add(ModBlocks.LIMONERO_WOOD.get())
                .add(ModBlocks.STRIPPED_LIMONERO_LOG.get())
                .add(ModBlocks.STRIPPED_LIMONERO_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.PALTO_PLANKS.get())
                .add(ModBlocks.LIMONERO_PLANKS.get());
    }
}
