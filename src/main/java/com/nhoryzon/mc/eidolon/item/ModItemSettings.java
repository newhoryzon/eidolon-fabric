package com.nhoryzon.mc.eidolon.item;

import com.nhoryzon.mc.eidolon.EidolonMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ModItemSettings extends FabricItemSettings {

    public ModItemSettings() {
        super();
        group(EidolonMod.ITEM_GROUP);
    }
    
}