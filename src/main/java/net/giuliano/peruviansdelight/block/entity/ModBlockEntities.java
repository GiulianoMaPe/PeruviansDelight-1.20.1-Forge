package net.giuliano.peruviansdelight.block.entity;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PeruviansDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<TendalBlockEntity>> TENDAL_BE =
            BLOCK_ENTITIES.register("tendal_be", () ->
                    BlockEntityType.Builder.of(TendalBlockEntity::new,
                            ModBlocks.TENDAL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}