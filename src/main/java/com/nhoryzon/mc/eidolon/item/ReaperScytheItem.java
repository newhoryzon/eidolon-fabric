package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

public class ReaperScytheItem extends SwordItemBase {

    public ReaperScytheItem() {
        super(EidolonToolMaterials.PEWTER_TIER, 5, -2.9f, new ModItemSettings().rarity(Rarity.UNCOMMON));
        this.setLore("lore.eidolon.reaper_scythe");
    }
}
