package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

//TODO
public class PrestigiousPalmItem extends ItemBase {

    public PrestigiousPalmItem() {
        super(new ModItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
        this.setLore("lore.prestigious_palm");
    }
}
