package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

// TODO
public class ReversalPickItem extends PickaxeItemBase {

    public ReversalPickItem() {
        super(EidolonToolMaterials.MAGIC_TOOL_TIER, 1, -2.8f, new ModItemSettings().rarity(Rarity.UNCOMMON));
    }
}
