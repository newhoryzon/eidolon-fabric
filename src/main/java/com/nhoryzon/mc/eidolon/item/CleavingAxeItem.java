package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

public class CleavingAxeItem extends AxeItemBase {

    public CleavingAxeItem() {
        super(EidolonToolMaterials.PEWTER_TIER, 7, -3.2f, new ModItemSettings().rarity(Rarity.UNCOMMON));
        this.setLore("lore.cleaving_axe");
    }

}
