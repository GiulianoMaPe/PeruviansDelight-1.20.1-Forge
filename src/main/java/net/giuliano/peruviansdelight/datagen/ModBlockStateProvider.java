package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.block.custom.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PeruviansDelight.MOD_ID, exFileHelper);
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(PeruviansDelight.MOD_ID, "block/" + path);
    }

    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CARA);

        this.customStageBlock((CropBlock) ModBlocks.AJI_AMARILLO_CROP.get(),
                this.resourceBlock("crop_cross"), "cross", AjiAmarilloCropBlock.AGE, new ArrayList());
        this.customStageBlock((CropBlock) ModBlocks.KION_CROP.get(),
                this.mcLoc("crop"), "crop", KionCropBlock.AGE, new ArrayList());
        this.customStageBlock((CropBlock) ModBlocks.SOYA_CROP.get(),
                this.resourceBlock("crop_cross"), "cross", SoyaCropBlock.AGE, new ArrayList());
        this.customStageBlock((CropBlock) ModBlocks.CAMOTE_CROP.get(),
                this.resourceBlock("crop_cross"), "cross", CamoteCropBlock.AGE, new ArrayList());
        this.customStageBlock((CropBlock) ModBlocks.YUCA_CROP.get(),
                this.resourceBlock("crop_cross"), "cross", YucaCropBlock.AGE, new ArrayList());
    }

    public void customStageBlock(CropBlock block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int ageSuffix = (Integer)state.getValue(ageProperty);
            String var10000 = this.blockName(block);
            String stageName = var10000 + "_stage";
            stageName = stageName + (suffixes.isEmpty() ? ageSuffix : (Integer)suffixes.get(Math.min(suffixes.size(), ageSuffix)));
            return parent == null ? ConfiguredModel.builder().modelFile(((BlockModelBuilder)this.models().cross(stageName, this.resourceBlock(stageName))).renderType("cutout")).build() : ConfiguredModel.builder().modelFile(((BlockModelBuilder)this.models().singleTexture(stageName, parent, textureKey, this.resourceBlock(stageName))).renderType("cutout")).build();
        }, ignored);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
