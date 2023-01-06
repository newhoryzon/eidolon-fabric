package com.nhoryzon.mc.eidolon.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityCollisionExtendsVerticallyMixin {

    @Inject(method = "getPosWithYOffset", at = @At("RETURN"), cancellable = true)
    private void getPosWithYOffset(float offset, CallbackInfoReturnable<BlockPos> cir) {

    }

}
