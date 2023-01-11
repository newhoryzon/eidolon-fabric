package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

public class GravityBeltItem extends ItemBase {

    public GravityBeltItem() {
        super(new ModItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
        this.setLore("lore.gravity_belt");
    }
}
