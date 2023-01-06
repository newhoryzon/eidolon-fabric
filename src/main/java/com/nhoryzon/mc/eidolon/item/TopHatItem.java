package com.nhoryzon.mc.eidolon.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Rarity;

// TODO
public class TopHatItem extends ArmorItemBase {

    public TopHatItem() {
        super(EidolonArmorMaterial.TOP_HAT_MATERIAL, EquipmentSlot.HEAD, new ModItemSettings().rarity(Rarity.EPIC).maxCount(1));
        this.setLore("lore.top_hat");
    }
}
