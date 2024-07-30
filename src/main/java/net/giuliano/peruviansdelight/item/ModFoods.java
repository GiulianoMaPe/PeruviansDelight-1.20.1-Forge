package net.giuliano.peruviansdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties INCA_KOLA = new FoodProperties.Builder().fast().alwaysEat().nutrition(4)
            .saturationMod(1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400), 1f)
            .build();

    public static final FoodProperties CAUSA = new FoodProperties.Builder().nutrition(12)
            .saturationMod(1f).build();
    public static final FoodProperties CAUSA_ATUN = new FoodProperties.Builder().nutrition(12)
            .saturationMod(1f).build();
    public static final FoodProperties CHAUFA = new FoodProperties.Builder().nutrition(10)
            .saturationMod(1f).build();
    public static final FoodProperties TALLARIN_SALTADO = new FoodProperties.Builder().nutrition(10)
            .saturationMod(1f).build();

    public static final FoodProperties TOCOSH = new FoodProperties.Builder().nutrition(8).fast().saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 1f)
            .build();


    public static final FoodProperties AJI_AMARILLO = new FoodProperties.Builder().nutrition(1).fast().saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1f).build();
    public static final FoodProperties CAMOTE = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.6f).build();
    public static final FoodProperties CAMOTE_COCIDO = new FoodProperties.Builder().nutrition(5).fast()
            .saturationMod(1.2f).meat().build();
    public static final FoodProperties YUCA = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.5f).build();
    public static final FoodProperties YUCA_FRITA = new FoodProperties.Builder().nutrition(6).fast()
            .saturationMod(1.3f).build();
    public static final FoodProperties ATUN = new FoodProperties.Builder().nutrition(10).fast()
            .saturationMod(0.1f).build();
    public static final FoodProperties FILETE_ATUN = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).build();
    public static final FoodProperties FILETE_ATUN_COCIDO = new FoodProperties.Builder().nutrition(6).fast()
            .saturationMod(0.5f).build();
    public static final FoodProperties LIMON = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 3), 1f)
            .build();
    public static final FoodProperties GAJO_LIMON = new FoodProperties.Builder().nutrition(1).fast()
            .saturationMod(1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1f)
            .build();
    public static final FoodProperties PALTA = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.5f).build();
    public static final FoodProperties PALTA_CORTADA = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.7f).build();
    public static final FoodProperties KION = new FoodProperties.Builder().nutrition(1).fast().saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1f).build();
}
