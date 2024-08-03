package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.block.custom.AjiAmarilloCropBlock;
import net.giuliano.peruviansdelight.block.custom.KionCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PeruviansDelight.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CARA);

        makeAjiAmarilloCrop((CropBlock) ModBlocks.AJI_AMARILLO_CROP.get(), "aji_amarillo_stage", "aji_amarillo_stage");
        makeKionCrop((CropBlock) ModBlocks.KION_CROP.get(), "kion_stage", "kion_stage");
    }

    public void makeAjiAmarilloCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> AjiAmarilloStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] AjiAmarilloStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((AjiAmarilloCropBlock) block).getAgeProperty()),
                new ResourceLocation(PeruviansDelight.MOD_ID, "block/" + textureName + state.getValue(((AjiAmarilloCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeKionCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> KionStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] KionStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KionCropBlock) block).getAgeProperty()),
                new ResourceLocation(PeruviansDelight.MOD_ID, "block/" + textureName + state.getValue(((KionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
