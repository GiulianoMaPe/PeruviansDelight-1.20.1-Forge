package net.giuliano.peruviansdelight.entity;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.custom.AtunEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PeruviansDelight.MOD_ID);

    public static final RegistryObject<EntityType<AtunEntity>> ATUN =
            ENTITY_TYPES.register("atun", () -> EntityType.Builder.of(AtunEntity::new, MobCategory.WATER_AMBIENT)
                    .sized(1.3f, 0.8f).clientTrackingRange(4).build("atun"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
