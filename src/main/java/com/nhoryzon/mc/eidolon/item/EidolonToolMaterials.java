package com.nhoryzon.mc.eidolon.item;

import com.google.common.base.Suppliers;
import com.nhoryzon.mc.eidolon.registry.ItemsRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum EidolonToolMaterials implements ToolMaterial {

    PEWTER_TIER(2, 325, 6.5f, 2, 8, () -> Ingredient.ofStacks(new ItemStack(ItemsRegistry.PEWTER_INGOT.get()))),
    MAGIC_TOOL_TIER(3, 1170, 7.0f, 3, 30, () -> Ingredient.EMPTY),
    SANGUINE_TIER(3, 507, 8.0f, 3, 20, () -> Ingredient.EMPTY)
    ;

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    EidolonToolMaterials(int miningLevel, int itemDurability, float miningSpeedMultiplier, float attackDamage,
                         int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

}
