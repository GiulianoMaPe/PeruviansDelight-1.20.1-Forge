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

        simpleItem(ModItems.POTE_AJI_AMARILLO);
        simpleItem(ModItems.SILLAO);
        simpleItem(ModItems.HUANCAINA);

        simpleItem(ModItems.ATUN_BUCKET);

        simpleItem(ModItems.VAINA_SOYA);
        simpleItem(ModItems.GRANOS_SOYA);
        simpleItem(ModItems.SEMILLAS_AJI_AMARILLO);

        saplingItem(ModBlocks.SEMILLA_PALTA);
        saplingItem(ModBlocks.SEMILLAS_LIMON);

        simpleItem(ModItems.ALMA_EN_PENA);

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
}
