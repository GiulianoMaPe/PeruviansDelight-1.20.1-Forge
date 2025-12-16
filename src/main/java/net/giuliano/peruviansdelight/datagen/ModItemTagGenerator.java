package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
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
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.FENCES, ItemTags.FENCES);
        this.copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

        this.tag(ForgeTags.RAW_FISHES)
                .add(ModItems.FILETE_ATUN.get());
    }
}
