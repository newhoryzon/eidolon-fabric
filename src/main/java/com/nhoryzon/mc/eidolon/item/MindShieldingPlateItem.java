package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

//TODO
public class MindShieldingPlateItem extends ItemBase {

    public MindShieldingPlateItem() {
        super(new ModItemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
        this.setLore("lore.mind_shielding_plate");
    }
}
