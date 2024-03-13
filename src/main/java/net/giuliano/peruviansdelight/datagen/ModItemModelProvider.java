package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
        simpleItem(ModItems.AJI_AMARILLO);
        simpleItem(ModItems.CAMOTE);
        simpleItem(ModItems.CAMOTE_COCIDO);
        simpleItem(ModItems.YUCA);
        simpleItem(ModItems.YUCA_FRITA);
        simpleItem(ModItems.ATUN);
        simpleItem(ModItems.ATUN_COCIDO);
        simpleItem(ModItems.LIMON);
        simpleItem(ModItems.GAJO_LIMON);

        simpleItem(ModItems.POTE_AJI_AMARILLO);
        simpleItem(ModItems.GRANOS_SOYA);
        simpleItem(ModItems.SILLAO);
        simpleItem(ModItems.ALMA_EN_PENA);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PeruviansDelight.MOD_ID,"item/" + item.getId().getPath()));
    }
}