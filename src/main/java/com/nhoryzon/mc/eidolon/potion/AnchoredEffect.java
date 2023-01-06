package com.nhoryzon.mc.eidolon.potion;

import com.nhoryzon.mc.eidolon.EidolonMod;
import com.nhoryzon.mc.eidolon.util.ColorUtil;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;

// TODO
public class AnchoredEffect extends StatusEffect {

    protected static final Identifier EFFECT_TEXTURE = Identifier.of(EidolonMod.MOD_ID, "textures/mob_effect/anchored.png");

    public AnchoredEffect() {
        super(StatusEffectCategory.BENEFICIAL, ColorUtil.packColor(255, 154, 58, 232));
    }
}
