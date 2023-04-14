package com.cowate.labmod;

import com.cowate.labmod.item.ThisItems;
import com.cowate.labmod.misc.effects.ThisStatusEffects;
import net.fabricmc.api.ModInitializer;


public class LabMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ThisItems.register();
        ThisStatusEffects.register();
    }
}
