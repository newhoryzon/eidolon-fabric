package com.nhoryzon.mc.eidolon.item;

import com.nhoryzon.mc.eidolon.EidolonMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PickaxeItemBase extends PickaxeItem {

    private String loreTag = null;

    public PickaxeItemBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public PickaxeItemBase setLore(String tag) {
        this.loreTag = tag;
        return this;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (this.loreTag != null) {
            tooltip.add(Text.literal(""));
            tooltip.add(EidolonMod.i18n(loreTag).formatted(Formatting.DARK_PURPLE, Formatting.ITALIC));
        }
    }
}
