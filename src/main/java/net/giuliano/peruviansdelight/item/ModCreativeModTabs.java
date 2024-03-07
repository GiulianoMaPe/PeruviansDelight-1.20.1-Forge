package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PeruviansDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PERUVIANSDELIGHT_TAB = CREATIVE_MODE_TABS.register("peruviansdelight_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CAUSA.get()))
                    .title(Component.translatable("creativetab.peruviansdelight_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CAUSA.get());
                        output.accept(ModItems.INCA_KOLA.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
