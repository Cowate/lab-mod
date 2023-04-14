package com.cowate.labmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ThisItems {
    public static final String ModId = "lab-mod";

    public static final Item THIS_PILL = ThisItems.register("this_pill", new ThisPill(new Item.Settings().group(ItemGroup.FOOD)));

    private static Item register(String id, Item entry) {
        return Registry.register(Registry.ITEM, new Identifier(ModId, id), entry);
    }

    public static void register() {

    }
}
