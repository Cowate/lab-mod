package com.cowate.labmod.item;

import com.cowate.labmod.misc.effects.ThisStatusEffects;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThisPill extends Item {
    public ThisPill(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack item = user.getStackInHand(hand);
        if (user.hasStatusEffect(ThisStatusEffects.PLAGUE)) {
            user.removeStatusEffect(ThisStatusEffects.PLAGUE);
            double o = user.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH);
            user.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(Math.min(20.0D, o + 4.0D));
        }
        else {
            user.addStatusEffect(new StatusEffectInstance(ThisStatusEffects.PLAGUE, 1000));
        }
        item.decrement(1);
        user.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 0.5F);
        return TypedActionResult.success(item);
    }
}
