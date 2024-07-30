package net.giuliano.peruviansdelight.item.custom;

import net.giuliano.peruviansdelight.entity.ModEntities;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluid;

public class AtunBucket extends MobBucketItem{
    public AtunBucket(EntityType<?> pType, Fluid pContent, SoundEvent pEmptySound, Properties pProperties) {
        super(pType, pContent, pEmptySound, pProperties);
    }

    @Override
    protected EntityType<?> getFishType() {
        return ModEntities.ATUN.get(); //Forzado
    }

}


