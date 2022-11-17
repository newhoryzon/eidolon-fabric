package com.nhoryzon.mc.eidolon;

import com.nhoryzon.mc.eidolon.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EidolonMod implements ModInitializer {

    public static final String MOD_NAME_PRETTY = "Eidolon";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME_PRETTY);

    public static final String MOD_ID = "eidolon";

    public static Configuration CONFIG = new Configuration();

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "main"),
            () -> new ItemStack(Items.IRON_INGOT));

    public static MutableText i18n(String key, Object... args) {
        return Text.translatable(MOD_ID + "." + key, args);
    }

    @Override
    public void onInitialize() {
        initConfiguration();

        BlocksRegistry.registerAll();
        ItemsRegistry.registerAll();
    }

    protected void initConfiguration() {
        CONFIG = Configuration.load();
    }

}