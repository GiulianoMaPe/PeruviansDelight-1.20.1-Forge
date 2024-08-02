package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.entity.ModEntities;
import net.giuliano.peruviansdelight.item.custom.AtunBucket;
import net.giuliano.peruviansdelight.item.custom.DrinkFoil;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PeruviansDelight.MOD_ID);

    public static final RegistryObject<Item> INCA_KOLA = ITEMS.register("inca_kola",
            () -> new DrinkFoil(new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .food(ModFoods.INCA_KOLA)));

    public static final RegistryObject<Item> CAUSA = ITEMS.register("causa",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.CAUSA)));
    public static final RegistryObject<Item> CAUSA_ATUN = ITEMS.register("causa_atun",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.CAUSA_ATUN)));
    public static final RegistryObject<Item> CHAUFA = ITEMS.register("chaufa",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.CHAUFA)));
    public static final RegistryObject<Item> TALLARIN_SALTADO = ITEMS.register("tallarin_saltado",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.TALLARIN_SALTADO)));
    public static final RegistryObject<Item> LOMO_SALTADO = ITEMS.register("lomo_saltado",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.LOMO_SALTADO)));
    public static final RegistryObject<Item> POLLO_BRASA = ITEMS.register("pollo_brasa",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.POLLO_BRASA)));
    public static final RegistryObject<Item> CEVICHE = ITEMS.register("ceviche",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.CEVICHE)));
    public static final RegistryObject<Item> AEROPUERTO = ITEMS.register("aeropuerto",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.AEROPUERTO)));
    public static final RegistryObject<Item> MOSTRITO = ITEMS.register("mostrito",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.MOSTRITO)));
    public static final RegistryObject<Item> PAPA_HUANCAINA = ITEMS.register("papa_huancaina",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.PAPA_HUANCAINA)));

    public static final RegistryObject<Item> TOCOSH = ITEMS.register("tocosh",
            () -> new ModDrinkItems(new Item.Properties().stacksTo(16).food(ModFoods.TOCOSH)));

    public static final RegistryObject<Item> AJI_AMARILLO = ITEMS.register("aji_amarillo",
            () -> new Item(new Item.Properties().food(ModFoods.AJI_AMARILLO)));
    public static final RegistryObject<Item> LIMON = ITEMS.register("limon",
            () -> new Item(new Item.Properties().food(ModFoods.LIMON)));
    public static final RegistryObject<Item> GAJO_LIMON = ITEMS.register("gajo_limon",
            () -> new Item(new Item.Properties().food(ModFoods.GAJO_LIMON)));
    public static final RegistryObject<Item> KION = ITEMS.register("kion",
            () -> new Item(new Item.Properties().food(ModFoods.KION)));

    public static final RegistryObject<Item> CAMOTE = ITEMS.register("camote",
            () -> new Item(new Item.Properties().food(ModFoods.CAMOTE)));
    public static final RegistryObject<Item> CAMOTE_COCIDO = ITEMS.register("camote_cocido",
            () -> new Item(new Item.Properties().food(ModFoods.CAMOTE_COCIDO)));
    public static final RegistryObject<Item> CAMOTE_CORTADO = ITEMS.register("camote_cortado",
            () -> new Item(new Item.Properties().food(ModFoods.CAMOTE_CORTADO)));
    public static final RegistryObject<Item> CAMOTE_FRITO= ITEMS.register("camote_frito",
            () -> new Item(new Item.Properties().food(ModFoods.CAMOTE_FRITO)));
    public static final RegistryObject<Item> YUCA = ITEMS.register("yuca",
            () -> new Item(new Item.Properties().food(ModFoods.YUCA)));
    public static final RegistryObject<Item> YUCA_CORTADA = ITEMS.register("yuca_cortada",
            () -> new Item(new Item.Properties().food(ModFoods.YUCA_CORTADA)));
    public static final RegistryObject<Item> YUCA_FRITA = ITEMS.register("yuca_frita",
            () -> new Item(new Item.Properties().food(ModFoods.YUCA_FRITA)));
    public static final RegistryObject<Item> ATUN = ITEMS.register("atun",
            () -> new Item(new Item.Properties().food(ModFoods.ATUN)));
    public static final RegistryObject<Item> FILETE_ATUN = ITEMS.register("filete_atun",
            () -> new Item(new Item.Properties().food(ModFoods.FILETE_ATUN)));
    public static final RegistryObject<Item> FILETE_ATUN_COCIDO = ITEMS.register("filete_atun_cocido",
            () -> new Item(new Item.Properties().food(ModFoods.FILETE_ATUN_COCIDO)));
    public static final RegistryObject<Item> PALTA = ITEMS.register("palta",
            () -> new Item(new Item.Properties().food(ModFoods.PALTA)));
    public static final RegistryObject<Item> PALTA_CORTADA = ITEMS.register("palta_cortada",
            () -> new Item(new Item.Properties().food(ModFoods.PALTA_CORTADA)));
    public static final RegistryObject<Item> PAPAS_CORTADAS = ITEMS.register("papas_cortadas",
            () -> new Item(new Item.Properties().food(ModFoods.PAPAS_CORTADAS)));
    public static final RegistryObject<Item> PAPAS_FRITAS = ITEMS.register("papas_fritas",
            () -> new Item(new Item.Properties().food(ModFoods.PAPAS_FRITAS)));
    public static final RegistryObject<Item> TENTACULO_POTA = ITEMS.register("tentaculo_pota",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.TENTACULO_POTA)));
    public static final RegistryObject<Item> POTA_CORTADO = ITEMS.register("pota_cortado",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.POTA_CORTADO)));
    public static final RegistryObject<Item> CHICHARRON_POTA = ITEMS.register("chicharron_pota",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16)
                    .food(ModFoods.CHICHARRON_POTA)));

    public static final RegistryObject<Item> POTE_AJI_AMARILLO = ITEMS.register("pote_aji_amarillo",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SILLAO = ITEMS.register("sillao",
            () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> HUANCAINA = ITEMS.register("huancaina",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> ATUN_BUCKET = ITEMS.register("atun_bucket",
            () -> new AtunBucket(EntityType.SALMON, Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH,
                    new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VAINA_SOYA = ITEMS.register("vaina_soya",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRANOS_SOYA = ITEMS.register("granos_soya",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SEMILLAS_AJI_AMARILLO = ITEMS.register("semillas_aji_amarillo",
            () -> new ItemNameBlockItem(ModBlocks.AJI_AMARILLO_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SEMILLA_PALTA = ITEMS.register("semilla_palta",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SEMILLAS_LIMON = ITEMS.register("semillas_limon",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ATUN_SPAWN_EGG = ITEMS.register("atun_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.ATUN, 0xb4d4e1, 0x195a75,
                    new Item.Properties()));

    public static final RegistryObject<Item> ALMA_EN_PENA = ITEMS.register("alma_en_pena",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}