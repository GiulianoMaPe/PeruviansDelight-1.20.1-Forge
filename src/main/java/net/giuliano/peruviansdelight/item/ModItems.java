package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PeruviansDelight.MOD_ID);

    public static final RegistryObject<Item> INCA_KOLA = ITEMS.register("inca_kola",
            () -> new Item(new Item.Properties().food(ModFoods.INCA_KOLA)));
    public static final RegistryObject<Item> CAUSA = ITEMS.register("causa",
            () -> new Item(new Item.Properties().food(ModFoods.CAUSA)));

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

    public static final RegistryObject<Item> POTE_AJI_AMARILLO = ITEMS.register("pote_aji_amarillo",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRANOS_SOYA = ITEMS.register("granos_soya",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILLAO = ITEMS.register("sillao",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALMA_EN_PENA = ITEMS.register("alma_en_pena",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
