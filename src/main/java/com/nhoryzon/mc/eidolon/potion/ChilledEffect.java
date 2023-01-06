package com.nhoryzon.mc.eidolon.potion;

import com.nhoryzon.mc.eidolon.EidolonMod;
import com.nhoryzon.mc.eidolon.util.ColorUtil;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

public class ChilledEffect extends StatusEffect {

    protected static final Identifier ICONS_TEXTURE = Identifier.of(EidolonMod.MOD_ID, "textures/gui/icons.png");
    protected static final Identifier EFFECT_TEXTURE = Identifier.of(EidolonMod.MOD_ID, "textures/mob_effect/chilled.png");

    public ChilledEffect() {
        super(StatusEffectCategory.HARMFUL, ColorUtil.packColor(255, 147, 189, 245));
    }
}
