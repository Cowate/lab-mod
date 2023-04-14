package com.cowate.labmod.misc.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ThisStatusEffects {
    public static final String ModId = "lab-mod";
    public static final StatusEffect PLAGUE = ThisStatusEffects.register("plague", new PlagueEffect());
    private static StatusEffect register(String id, StatusEffect entry){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(ModId, id), entry);
    }

    public static void register(){

    }
}
