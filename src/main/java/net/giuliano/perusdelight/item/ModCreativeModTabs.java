package net.giuliano.perusdelight.item;

import net.giuliano.perusdelight.PerusDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PerusDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PERUSDELIGHT_TAB = CREATIVE_MODE_TABS.register("perusdelight_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CAUSA.get()))
                    .title(Component.translatable("creativetab.perusdelight_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CAUSA.get());
                        output.accept(ModItems.INCA_KOLA.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
