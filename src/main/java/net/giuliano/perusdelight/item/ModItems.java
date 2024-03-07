package net.giuliano.perusdelight.item;

import net.giuliano.perusdelight.PerusDelight;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PerusDelight.MOD_ID);

    public static final RegistryObject<Item> CAUSA = ITEMS.register("causa",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INCA_KOLA = ITEMS.register("inca_kola",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
