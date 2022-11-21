package com.nhoryzon.mc.eidolon.item;

import com.nhoryzon.mc.eidolon.EidolonMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArmorItemBase extends ArmorItem {

    private String loreTag = null;

    public ArmorItemBase(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    public ArmorItem setLore(String tag) {
        this.loreTag = tag;
        return this;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (this.loreTag != null) {
            tooltip.add(Text.literal(""));
            tooltip.add(EidolonMod.i18n(loreTag).formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        }
    }
}
