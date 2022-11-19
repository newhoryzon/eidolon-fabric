package com.nhoryzon.mc.eidolon.item;

import com.nhoryzon.mc.eidolon.EidolonMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ItemBase extends Item {

    private String loreTag = null;

    public ItemBase(Settings settings) {
        super(settings);
    }

    public ItemBase setLore(String tag) {
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
