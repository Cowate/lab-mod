package com.cowate.labmod.mixin;

import com.cowate.labmod.misc.effects.ThisStatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ZombieEntity.class)
public abstract class BuffNormalZombie {
    public boolean bl;
    @ModifyVariable(method = "tryAttack", at = @At("STORE"), ordinal = 0)
    private boolean getbl(boolean b) {
        bl = b;
        return b;
    }
    @ModifyVariable(method = "tryAttack", at = @At(value = "RETURN"), argsOnly = true)
    private Entity addEffect(Entity target) {
        if (bl && ((ZombieEntity)(Object)this).getMainHandStack().isEmpty() && target instanceof LivingEntity) {
            float f = ((ZombieEntity)(Object)this).world.getLocalDifficulty(((ZombieEntity)(Object)this).getBlockPos()).getLocalDifficulty();
            // control in applyUpdateEffect
            ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(ThisStatusEffects.PLAGUE, 1000 * (int)f));
        }
        return target;
    }
    // Mixin Debug Mode Disable?
}
