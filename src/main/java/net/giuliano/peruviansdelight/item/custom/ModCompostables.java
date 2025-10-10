package net.giuliano.peruviansdelight.item.custom;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.world.level.block.ComposterBlock;

public class ModCompostables {
    public static void register() {
        ComposterBlock.COMPOSTABLES.put(ModItems.AJI_AMARILLO.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.SEMILLAS_AJI_AMARILLO.get(), 0.3f);

        ComposterBlock.COMPOSTABLES.put(ModItems.CAMOTE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CAMOTE_COCIDO.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CAMOTE_CORTADO.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CAMOTE_FRITO.get(), 0.7f);

        ComposterBlock.COMPOSTABLES.put(ModItems.KION.get(), 0.65f);

        ComposterBlock.COMPOSTABLES.put(ModItems.VAINA_SOYA.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.GRANOS_SOYA.get(), 0.3f);

        ComposterBlock.COMPOSTABLES.put(ModItems.YUCA.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.YUCA_CORTADA.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(ModItems.YUCA_FRITA.get(), 0.70f);

        ComposterBlock.COMPOSTABLES.put(ModItems.LIMON.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.GAJO_LIMON.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.SEMILLAS_LIMON.get(), 0.3f);

        ComposterBlock.COMPOSTABLES.put(ModItems.PALTA.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.PALTA_CORTADA.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(ModBlocks.SEMILLA_PALTA.get(), 0.3f);

        ComposterBlock.COMPOSTABLES.put(ModItems.PAPAS_CORTADAS.get(), 0.5f);
    }
}
