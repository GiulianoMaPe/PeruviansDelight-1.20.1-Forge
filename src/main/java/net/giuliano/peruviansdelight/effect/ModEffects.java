package net.giuliano.peruviansdelight.effect;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PeruviansDelight.MOD_ID);

    public static final RegistryObject<MobEffect> GLUGLUGLU = MOB_EFFECTS.register("glugluglu",
            () -> new GluGluGluAAAAH(MobEffectCategory.HARMFUL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
