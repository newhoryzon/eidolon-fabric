package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

// TODO
public class ResoluteBeltItem extends ItemBase {

    public ResoluteBeltItem() {
        super(new ModItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
        this.setLore("lore.resolute_belt");
    }
}
