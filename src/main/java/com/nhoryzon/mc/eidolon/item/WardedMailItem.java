package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

//TODO
public class WardedMailItem extends ItemBase {

    public WardedMailItem() {
        super(new ModItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
        this.setLore("lore.warded_mail");
    }
}
