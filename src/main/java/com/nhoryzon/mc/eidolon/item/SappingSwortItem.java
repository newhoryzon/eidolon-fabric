package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

// TODO
public class SappingSwortItem extends SwordItemBase {

    public SappingSwortItem() {
        super(EidolonToolMaterials.SANGUINE_TIER, 1, -2.4f, new ModItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
        this.setLore("lore.sapping_sword");
    }
}
