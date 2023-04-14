package com.cowate.labmod.misc.effects;

import com.cowate.labmod.utils.ThisDamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.player.PlayerEntity;

public class PlagueEffect extends StatusEffect {

    protected PlagueEffect() {
        super(StatusEffectType.HARMFUL, 0x5bac46);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == ThisStatusEffects.PLAGUE) {
            int i = 150 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
            return true;
        }
        return super.canApplyUpdateEffect(duration, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.world.isClient) {
            if (entity instanceof PlayerEntity) {
                double o = ((PlayerEntity)entity).getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH);
                ((PlayerEntity)entity).damage(ThisDamageSource.PLAGUE, 2);
                ((PlayerEntity)entity).getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(o - 2);
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
