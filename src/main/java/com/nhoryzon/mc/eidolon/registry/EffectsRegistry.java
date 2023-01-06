package com.nhoryzon.mc.eidolon.registry;

import com.nhoryzon.mc.eidolon.EidolonMod;
import com.nhoryzon.mc.eidolon.potion.AnchoredEffect;
import com.nhoryzon.mc.eidolon.potion.ChilledEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum EffectsRegistry {

    ANCHORED("anchored", new AnchoredEffect()),
    CHILLED("chilled", new ChilledEffect());

    private final String pathName;
    private final StatusEffect effect;

    EffectsRegistry(String pathName, StatusEffect effect) {
        this.pathName = pathName;
        this.effect = effect;
    }

    public static void registerAll() {
        for (EffectsRegistry value: values()) {
            Registry.register(Registry.STATUS_EFFECT, new Identifier(EidolonMod.MOD_ID, value.pathName), value.effect);
        }
    }

    public StatusEffect get() {
        return effect;
    }
}
