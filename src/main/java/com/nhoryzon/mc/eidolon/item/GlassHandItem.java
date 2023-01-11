package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

//TODO
public class GlassHandItem extends ItemBase {

    public GlassHandItem() {
        super(new ModItemSettings().rarity(Rarity.RARE).maxCount(1));
        this.setLore("lore.glass_hand");
    }
}
