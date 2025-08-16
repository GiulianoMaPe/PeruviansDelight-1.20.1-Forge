package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PeruviansDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.INCA_KOLA);

        simpleItem(ModItems.CAUSA);
        simpleItem(ModItems.CAUSA_ATUN);
        simpleItem(ModItems.CHAUFA);
        simpleItem(ModItems.TALLARIN_SALTADO);
        simpleItem(ModItems.LOMO_SALTADO);
        simpleItem(ModItems.POLLO_BRASA);
        simpleItem(ModItems.CEVICHE);
        simpleItem(ModItems.AEROPUERTO);
        simpleItem(ModItems.MOSTRITO);
        simpleItem(ModItems.PAPA_HUANCAINA);

        simpleItem(ModItems.TOCOSH);

        simpleItem(ModItems.AJI_AMARILLO);
        simpleItem(ModItems.LIMON);
        simpleItem(ModItems.GAJO_LIMON);
        simpleItem(ModItems.KION);

        simpleItem(ModItems.CAMOTE);
        simpleItem(ModItems.CAMOTE_COCIDO);
        simpleItem(ModItems.CAMOTE_CORTADO);
        simpleItem(ModItems.CAMOTE_FRITO);
        simpleItem(ModItems.YUCA);
        simpleItem(ModItems.YUCA_CORTADA);
        simpleItem(ModItems.YUCA_FRITA);
        simpleItem(ModItems.ATUN);
        simpleItem(ModItems.FILETE_ATUN);
        simpleItem(ModItems.FILETE_ATUN_COCIDO);
        simpleItem(ModItems.PALTA);
        simpleItem(ModItems.PALTA_CORTADA);
        simpleItem(ModItems.PAPAS_CORTADAS);
        simpleItem(ModItems.PAPAS_FRITAS);
        simpleItem(ModItems.TENTACULO_POTA);
        simpleItem(ModItems.POTA_CORTADO);
        simpleItem(ModItems.CHICHARRON_POTA);

        simpleItem(ModItems.BEEF_HEART);
        simpleItem(ModItems.RAW_HEART_SLICES);
        simpleItem(ModItems.RAW_ANTICUCHO);
        simpleItem(ModItems.ANTICUCHO);
        simpleItem(ModItems.MASA_PICARONES);
        simpleItem(ModItems.PICARONES);

        simpleItem(ModItems.POTE_AJI_AMARILLO);
        simpleItem(ModItems.SILLAO);
        simpleItem(ModItems.HUANCAINA);

        simpleItem(ModItems.ATUN_BUCKET);

        simpleItem(ModItems.VAINA_SOYA);
        simpleItem(ModItems.GRANOS_SOYA);
        simpleItem(ModItems.SEMILLAS_AJI_AMARILLO);

        saplingItem(ModBlocks.SEMILLA_PALTA);
        saplingItem(ModBlocks.SEMILLAS_LIMON);

        simpleBlockItem(ModBlocks.PALTO_DOOR);
        simpleBlockItem(ModBlocks.LIMONERO_DOOR);

        fenceItem(ModBlocks.PALTO_FENCE, ModBlocks.PALTO_PLANKS);
        fenceItem(ModBlocks.LIMONERO_FENCE, ModBlocks.LIMONERO_PLANKS);

        buttonItem(ModBlocks.PALTO_BUTTON, ModBlocks.PALTO_PLANKS);
        buttonItem(ModBlocks.LIMONERO_BUTTON, ModBlocks.LIMONERO_PLANKS);

        evenSimplerBlockItem(ModBlocks.PALTO_STAIRS);
        evenSimplerBlockItem(ModBlocks.PALTO_SLAB);
        evenSimplerBlockItem(ModBlocks.PALTO_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.PALTO_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.LIMONERO_STAIRS);
        evenSimplerBlockItem(ModBlocks.LIMONERO_SLAB);
        evenSimplerBlockItem(ModBlocks.LIMONERO_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.LIMONERO_FENCE_GATE);

        trapdoorItem(ModBlocks.PALTO_TRAPDOOR);
        trapdoorItem(ModBlocks.LIMONERO_TRAPDOOR);

        simpleBlockItemBlockTexture(ModBlocks.AJI_AMARILLO_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.KION_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.SOYA_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.CAMOTE_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.YUCA_SILVESTRE);

        withExistingParent(ModItems.ATUN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PeruviansDelight.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PeruviansDelight.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PeruviansDelight.MOD_ID, "block/" + item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(PeruviansDelight.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
            .texture("texture", new ResourceLocation(PeruviansDelight.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PeruviansDelight.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(PeruviansDelight.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
}
