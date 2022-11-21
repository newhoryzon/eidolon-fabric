package com.nhoryzon.mc.eidolon.item;

import net.minecraft.util.Rarity;

// TODO
public class CodexItem extends ItemBase {

    public CodexItem() {
        super(new ModItemSettings().maxCount(1).rarity(Rarity.UNCOMMON));
        this.setLore("lore.eidolon.codex");
    }
}
