package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

//TODO
public class SanguineAmuletItem extends ItemBase {

    public SanguineAmuletItem() {
        super(new ModItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
        this.setLore("lore.sanguine_amulet");
    }
}
