package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, PeruviansDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALTO_LOG.get().asItem())
                .add(ModBlocks.PALTO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PALTO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PALTO_WOOD.get().asItem())
                .add(ModBlocks.LIMONERO_LOG.get().asItem())
                .add(ModBlocks.LIMONERO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_LIMONERO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_LIMONERO_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.PALTO_PLANKS.get().asItem())
                .add(ModBlocks.LIMONERO_PLANKS.get().asItem());

        this.tag(ForgeTags.RAW_FISHES)
                .add(ModItems.FILETE_ATUN.get());
    }
}
