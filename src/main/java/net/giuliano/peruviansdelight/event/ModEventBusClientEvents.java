package net.giuliano.peruviansdelight.event;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.ModEntities;
import net.giuliano.peruviansdelight.entity.client.AtunModel;
import net.giuliano.peruviansdelight.entity.client.ModModelLayers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PeruviansDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ATUN_LAYER, AtunModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.ATUN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractSchoolingFish::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
