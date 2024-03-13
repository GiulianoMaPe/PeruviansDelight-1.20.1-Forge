package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PeruviansDelight.MOD_ID);

    public static final RegistryObject<Item> INCA_KOLA = ITEMS.register("inca_kola",
            () -> new ModDrinkItems(new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .food(ModFoods.INCA_KOLA)));

    public static final RegistryObject<Item> CAUSA = ITEMS.register("causa",
            () -> new Item(new Item.Properties().stacksTo(16)
                    .food(ModFoods.CAUSA)));
    public static final RegistryObject<Item> CAUSA_ATUN = ITEMS.register("causa_atun",
            () -> new Item(new Item.Properties().stacksTo(16)
                    .food(ModFoods.CAUSA_ATUN)));

    public static final RegistryObject<Item> AJI_AMARILLO = ITEMS.register("aji_amarillo",
            () -> new Item(new Item.Properties().food(ModFoods.AJI_AMARILLO)));
    public static final RegistryObject<Item> CAMOTE = ITEMS.register("camote",
            () -> new Item(new Item.Properties().food(ModFoods.CAMOTE)));
    public static final RegistryObject<Item> CAMOTE_COCIDO = ITEMS.register("camote_cocido",
            () -> new Item(new Item.Properties().food(ModFoods.CAMOTE_COCIDO)));
    public static final RegistryObject<Item> YUCA = ITEMS.register("yuca",
            () -> new Item(new Item.Properties().food(ModFoods.YUCA)));
    public static final RegistryObject<Item> YUCA_FRITA = ITEMS.register("yuca_frita",
            () -> new Item(new Item.Properties().food(ModFoods.YUCA_FRITA)));
    public static final RegistryObject<Item> ATUN = ITEMS.register("atun",
            () -> new Item(new Item.Properties().food(ModFoods.ATUN)));
    public static final RegistryObject<Item> ATUN_COCIDO = ITEMS.register("atun_cocido",
            () -> new Item(new Item.Properties().food(ModFoods.ATUN_COCIDO)));
    public static final RegistryObject<Item> LIMON = ITEMS.register("limon",
            () -> new Item(new Item.Properties().food(ModFoods.LIMON)));
    public static final RegistryObject<Item> GAJO_LIMON = ITEMS.register("gajo_limon",
            () -> new Item(new Item.Properties().food(ModFoods.GAJO_LIMON)));
    public static final RegistryObject<Item> PALTA = ITEMS.register("palta",
            () -> new Item(new Item.Properties().food(ModFoods.PALTA)));
    public static final RegistryObject<Item> PALTA_CORTADA = ITEMS.register("palta_cortada",
            () -> new Item(new Item.Properties().food(ModFoods.PALTA_CORTADA)));

    public static final RegistryObject<Item> POTE_AJI_AMARILLO = ITEMS.register("pote_aji_amarillo",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SILLAO = ITEMS.register("sillao",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> VAINA_SOYA = ITEMS.register("vaina_soya",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRANOS_SOYA = ITEMS.register("granos_soya",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SEMILLAS_AJI_AMARILLO = ITEMS.register("semillas_aji_amarillo",
            () -> new ItemNameBlockItem(ModBlocks.AJI_AMARILLO_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SEMILLA_PALTA = ITEMS.register("semilla_palta",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALMA_EN_PENA = ITEMS.register("alma_en_pena",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
