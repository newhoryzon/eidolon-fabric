package com.nhoryzon.mc.eidolon.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public abstract class WandItem extends ItemBase implements IRechargeableWand {

    public WandItem() {
        super(new ModItemSettings().rarity(Rarity.UNCOMMON).maxDamage(253).maxCount(1));
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    // TODO: forge
    /*@Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchant) {
        return super.canApplyAtEnchantingTable(stack, enchant)
                || enchant == Enchantments.UNBREAKING
                || enchant == Enchantments.MENDING;
    }*/

    @Override
    public ItemStack recharge(ItemStack stack) {
        stack.setDamage(0);
        return stack;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }
}
