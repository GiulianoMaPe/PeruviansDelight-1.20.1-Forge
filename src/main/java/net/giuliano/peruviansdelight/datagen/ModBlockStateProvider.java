package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.block.custom.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;

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

        logBlock(((RotatedPillarBlock) ModBlocks.PALTO_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.PALTO_WOOD.get()), blockTexture(ModBlocks.PALTO_LOG.get()), blockTexture(ModBlocks.PALTO_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PALTO_LOG.get()), blockTexture(ModBlocks.STRIPPED_PALTO_LOG.get()),
                new ResourceLocation(PeruviansDelight.MOD_ID, "block/stripped_palto_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PALTO_WOOD.get()), blockTexture(ModBlocks.STRIPPED_PALTO_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_PALTO_LOG.get()));

        blockItem(ModBlocks.PALTO_LOG);
        blockItem(ModBlocks.PALTO_WOOD);
        blockItem(ModBlocks.STRIPPED_PALTO_LOG);
        blockItem(ModBlocks.STRIPPED_PALTO_WOOD);

        blockWithItem(ModBlocks.PALTO_PLANKS);

        leavesBlock(ModBlocks.PALTO_LEAVES);
        leavesBlock(ModBlocks.PALTO_LEAVES_EMPTY);

        logBlock(((RotatedPillarBlock) ModBlocks.LIMONERO_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.LIMONERO_WOOD.get()), blockTexture(ModBlocks.LIMONERO_LOG.get()), blockTexture(ModBlocks.LIMONERO_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LIMONERO_LOG.get()), blockTexture(ModBlocks.STRIPPED_LIMONERO_LOG.get()),
                new ResourceLocation(PeruviansDelight.MOD_ID, "block/stripped_limonero_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LIMONERO_WOOD.get()), blockTexture(ModBlocks.STRIPPED_LIMONERO_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_LIMONERO_LOG.get()));

        blockItem(ModBlocks.LIMONERO_LOG);
        blockItem(ModBlocks.LIMONERO_WOOD);
        blockItem(ModBlocks.STRIPPED_LIMONERO_LOG);
        blockItem(ModBlocks.STRIPPED_LIMONERO_WOOD);

        blockWithItem(ModBlocks.LIMONERO_PLANKS);

        leavesBlock(ModBlocks.LIMONERO_LEAVES);
        leavesBlock(ModBlocks.LIMONERO_LEAVES_EMPTY);

        saplingBlock(ModBlocks.SEMILLA_PALTA);
        saplingBlock(ModBlocks.SEMILLAS_LIMON);

        stairsBlock(((StairBlock) ModBlocks.PALTO_STAIRS.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.PALTO_SLAB.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.PALTO_BUTTON.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.PALTO_PRESSURE_PLATE.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.PALTO_FENCE.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.PALTO_FENCE_GATE.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.PALTO_DOOR.get()), modLoc("block/palto_door_bottom"), modLoc("block/palto_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.PALTO_TRAPDOOR.get()), modLoc("block/palto_trapdoor"), true, "cutout");

        stairsBlock(((StairBlock) ModBlocks.LIMONERO_STAIRS.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.LIMONERO_SLAB.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        buttonBlock(((ButtonBlock) ModBlocks.LIMONERO_BUTTON.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LIMONERO_PRESSURE_PLATE.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        fenceBlock(((FenceBlock) ModBlocks.LIMONERO_FENCE.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.LIMONERO_FENCE_GATE.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.LIMONERO_DOOR.get()), modLoc("block/limonero_door_bottom"), modLoc("block/limonero_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LIMONERO_TRAPDOOR.get()), modLoc("block/limonero_trapdoor"), true, "cutout");

        simpleBlockWithItem(ModBlocks.AJI_AMARILLO_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.AJI_AMARILLO_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.AJI_AMARILLO_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.KION_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.KION_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.KION_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.SOYA_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.SOYA_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.SOYA_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.CAMOTE_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.CAMOTE_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.CAMOTE_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.YUCA_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.YUCA_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.YUCA_SILVESTRE.get())).renderType("cutout"));

        crateBlock(ModBlocks.AJI_AMARILLO_CRATE);
        crateBlock(ModBlocks.CAMOTE_CRATE);
        crateBlock(ModBlocks.KION_CRATE);
        crateBlock(ModBlocks.LIMON_CRATE);
        crateBlock(ModBlocks.PALTA_CRATE);
        crateBlock(ModBlocks.SOYA_CRATE);
        crateBlock(ModBlocks.YUCA_CRATE);

        bagBlock(ModBlocks.SOYA_BAG);
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
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

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(PeruviansDelight.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void crateBlock(RegistryObject<Block> deferredBlock) {
        String name = deferredBlock.getId().getPath();

        simpleBlock(deferredBlock.get(), models().cubeBottomTop(
                name,
                modLoc("block/" + name + "_side"),
                modLoc("block/crate_bottom"),
                modLoc("block/" + name + "_top")
        ));

        blockItem(deferredBlock);
    }

    public void bagBlock(RegistryObject<Block> deferredBlock) {
        String name = deferredBlock.getId().getPath();

        simpleBlock(deferredBlock.get(), models().cube(
                name,
                modLoc("block/bag_bottom"),
                modLoc("block/" + name + "_top"),
                modLoc("block/bag_side_tied"),
                modLoc("block/bag_side_tied"),
                modLoc("block/bag_side"),
                modLoc("block/bag_side")
        ).texture("particle", modLoc("block/" + name + "_top")));

        blockItem(deferredBlock);
    }
}
