package com.nhoryzon.mc.eidolon.item;

import com.nhoryzon.mc.eidolon.EidolonMod;
import com.nhoryzon.mc.eidolon.registry.ItemsRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.Objects;

public enum EidolonArmorMaterial implements ArmorMaterial {

    TOP_HAT_MATERIAL("top_hat", 7, 12,Ingredient.ofStacks(new ItemStack(Items.BLACK_WOOL))),
    WARLOCK_ROBE_MATERIAL("warlock_robes", 21, 25, Ingredient.ofStacks(new ItemStack(ItemsRegistry.WICKED_WEAVE.get())));

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    private final int durabilityMultiplier;
    private final int enchantability;
    private final Ingredient repairIngredient;
    private final String name;

    EidolonArmorMaterial(String name, int durabilityMultiplier, int enchantability, Ingredient repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability(EquipmentSlot slot) {
        return MAX_DAMAGE_ARRAY[slot.getEntitySlotId()] * durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        if (this == TOP_HAT_MATERIAL) {
            return 1;
        }
        return switch (slot) {
            case CHEST -> 7;
            case HEAD -> 3;
            case FEET -> 2;
            default -> 0;
        };
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return ArmorMaterials.LEATHER.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    public String getName() {
        return Objects.requireNonNull(Identifier.of(EidolonMod.MOD_ID, this.name)).toString();
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
