package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
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
                        output.accept(ModItems.INCA_KOLA.get());

                        output.accept(ModItems.CAUSA.get());
                        output.accept(ModItems.CAUSA_ATUN.get());
                        output.accept(ModItems.CHAUFA.get());
                        output.accept(ModItems.TALLARIN_SALTADO.get());
                        output.accept(ModItems.LOMO_SALTADO.get());
                        output.accept(ModItems.POLLO_BRASA.get());
                        output.accept(ModItems.CEVICHE.get());

                        output.accept(ModItems.AJI_AMARILLO.get());
                        output.accept(ModItems.CAMOTE.get());
                        output.accept(ModItems.CAMOTE_COCIDO.get());
                        output.accept(ModItems.CAMOTE_CORTADO.get());
                        output.accept(ModItems.CAMOTE_FRITO.get());
                        output.accept(ModItems.YUCA.get());
                        output.accept(ModItems.YUCA_CORTADA.get());
                        output.accept(ModItems.YUCA_FRITA.get());
                        output.accept(ModItems.ATUN.get());
                        output.accept(ModItems.FILETE_ATUN.get());
                        output.accept(ModItems.FILETE_ATUN_COCIDO.get());
                        output.accept(ModItems.LIMON.get());
                        output.accept(ModItems.GAJO_LIMON.get());
                        output.accept(ModItems.PALTA.get());
                        output.accept(ModItems.PALTA_CORTADA.get());
                        output.accept(ModItems.TOCOSH.get());
                        output.accept(ModItems.KION.get());
                        output.accept(ModItems.PAPAS_CORTADAS.get());
                        output.accept(ModItems.PAPAS_FRITAS.get());

                        output.accept(ModItems.POTE_AJI_AMARILLO.get());
                        output.accept(ModItems.SILLAO.get());
                        output.accept(ModItems.HUANCAINA.get());

                        output.accept(ModItems.ATUN_BUCKET.get());

                        output.accept(ModItems.VAINA_SOYA.get());
                        output.accept(ModItems.GRANOS_SOYA.get());
                        output.accept(ModItems.SEMILLAS_AJI_AMARILLO.get());
                        output.accept(ModItems.SEMILLA_PALTA.get());
                        output.accept(ModItems.SEMILLAS_LIMON.get());

                        output.accept(ModItems.ATUN_SPAWN_EGG.get());

                        output.accept(ModBlocks.CARA.get());
                        output.accept(ModItems.ALMA_EN_PENA.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
