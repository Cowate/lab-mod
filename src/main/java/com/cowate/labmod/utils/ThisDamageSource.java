package com.cowate.labmod.utils;

import net.minecraft.entity.damage.DamageSource;

public class ThisDamageSource extends DamageSource{
    public static final DamageSource PLAGUE = new ThisDamageSource("plague");

    protected ThisDamageSource(String name) {
        super(name);
    }
}
