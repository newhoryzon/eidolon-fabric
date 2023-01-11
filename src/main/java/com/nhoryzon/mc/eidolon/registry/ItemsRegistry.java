package com.nhoryzon.mc.eidolon.registry;

import com.nhoryzon.mc.eidolon.EidolonMod;
import com.nhoryzon.mc.eidolon.item.BonechillWandItem;
import com.nhoryzon.mc.eidolon.item.CleavingAxeItem;
import com.nhoryzon.mc.eidolon.item.CodexItem;
import com.nhoryzon.mc.eidolon.item.ModBlockItem;
import com.nhoryzon.mc.eidolon.item.ModItemSettings;
import com.nhoryzon.mc.eidolon.item.ReaperScytheItem;
import com.nhoryzon.mc.eidolon.item.ReversalPickItem;
import com.nhoryzon.mc.eidolon.item.SappingSwortItem;
import com.nhoryzon.mc.eidolon.item.SoulfireWandItem;
import com.nhoryzon.mc.eidolon.item.TopHatItem;
import com.nhoryzon.mc.eidolon.item.UnholySymbolItem;
import com.nhoryzon.mc.eidolon.item.WarlockRobesItem;
import com.nhoryzon.mc.eidolon.item.BasicAmuletItem;
import com.nhoryzon.mc.eidolon.item.BasicBeltItem;
import com.nhoryzon.mc.eidolon.item.BasicRingItem;
import com.nhoryzon.mc.eidolon.item.GlassHandItem;
import com.nhoryzon.mc.eidolon.item.GravityBeltItem;
import com.nhoryzon.mc.eidolon.item.MindShieldingPlateItem;
import com.nhoryzon.mc.eidolon.item.PrestigiousPalmItem;
import com.nhoryzon.mc.eidolon.item.ResoluteBeltItem;
import com.nhoryzon.mc.eidolon.item.SanguineAmuletItem;
import com.nhoryzon.mc.eidolon.item.VoidAmuletItem;
import com.nhoryzon.mc.eidolon.item.WardedMailItem;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public enum ItemsRegistry {

    /* Block Items */

    LEAD_ORE("lead_ore", () -> new ModBlockItem(BlocksRegistry.LEAD_ORE.get())),
    LEAD_BLOCK("lead_block", () -> new ModBlockItem(BlocksRegistry.LEAD_BLOCK.get())),
    PEWTER_BLOCK("pewter_block", () -> new ModBlockItem(BlocksRegistry.PEWTER_BLOCK.get())),
    ARCANE_GOLD_BLOCK("arcane_gold_block", () -> new ModBlockItem(BlocksRegistry.ARCANE_GOLD_BLOCK.get())),
    WOODEN_ALTAR("wooden_altar", () -> new ModBlockItem(BlocksRegistry.WOODEN_ALTAR.get())),
    STONE_ALTAR("stone_altar", () -> new ModBlockItem(BlocksRegistry.STONE_ALTAR.get())),
    CANDLE("candle", () -> new ModBlockItem(BlocksRegistry.CANDLE.get())),
    CANDLESTICK("candlestick", () -> new ModBlockItem(BlocksRegistry.CANDLESTICK.get())),
    STRAW_EFFIGY("straw_effigy", () -> new ModBlockItem(BlocksRegistry.STRAW_EFFIGY.get())),
    GOBLET("goblet", () -> new ModBlockItem(BlocksRegistry.GOBLET.get())),
    UNHOLY_EFFIGY("unholy_effigy", () -> new ModBlockItem(BlocksRegistry.UNHOLY_EFFIGY.get())),
    WORKTABLE("worktable", () -> new ModBlockItem(BlocksRegistry.WORKTABLE.get())),
    PLINTH("plinth", () -> new ModBlockItem(BlocksRegistry.PLINTH.get())),
    BRAZIER("brazier", () -> new ModBlockItem(BlocksRegistry.BRAZIER.get())),
    CRUCIBLE("crucible", () -> new ModBlockItem(BlocksRegistry.CRUCIBLE.get())),
    STONE_HAND("stone_hand", () -> new ModBlockItem(BlocksRegistry.STONE_HAND.get())),
    ENCHANTED_ASH("enchanted_ash", () -> new ModBlockItem(BlocksRegistry.ENCHANTED_ASH.get())),
    NECROTIC_FOCUS("necrotic_focus", () -> new ModBlockItem(BlocksRegistry.NECROTIC_FOCUS.get())),
    SOUL_ENCHANTER("soul_enchanter", () -> new ModBlockItem(BlocksRegistry.SOUL_ENCHANTER.get())),
    WOODEN_STAND("wooden_brewing_stand", () -> new ModBlockItem(BlocksRegistry.WOODEN_STAND.get())),

    SMOOTH_STONE_BRICKS("smooth_stone_bricks", () -> new ModBlockItem(BlocksRegistry.SMOOTH_STONE_BRICKS.get())),
    SMOOTH_STONE_BRICKS_SLAB("smooth_stone_bricks_slab", () -> new ModBlockItem(BlocksRegistry.SMOOTH_STONE_BRICKS_SLAB.get())),
    SMOOTH_STONE_BRICKS_STAIRS("smooth_stone_bricks_stairs", () -> new ModBlockItem(BlocksRegistry.SMOOTH_STONE_BRICKS_STAIRS.get())),
    SMOOTH_STONE_BRICKS_WALL("smooth_stone_bricks_wall", () -> new ModBlockItem(BlocksRegistry.SMOOTH_STONE_BRICKS_WALL.get())),
    SMOOTH_STONE_TILES("smooth_stone_tiles", () -> new ModBlockItem(BlocksRegistry.SMOOTH_STONE_TILES.get())),
    SMOOTH_STONE_TILES_SLAB("smooth_stone_tiles_slab", () -> new ModBlockItem(BlocksRegistry.SMOOTH_STONE_TILES_SLAB.get())),
    SMOOTH_STONE_TILES_STAIRS("smooth_stone_tiles_stairs", () -> new ModBlockItem(BlocksRegistry.SMOOTH_STONE_TILES_STAIRS.get())),
    POLISHED_PLANKS("polished_planks", () -> new ModBlockItem(BlocksRegistry.POLISHED_PLANKS.get())),
    POLISHED_PLANKS_SLAB("polished_planks_slab", () -> new ModBlockItem(BlocksRegistry.POLISHED_PLANKS_SLAB.get())),
    POLISHED_PLANKS_STAIRS("polished_planks_stairs", () -> new ModBlockItem(BlocksRegistry.POLISHED_PLANKS_STAIRS.get())),
    POLISHED_PLANKS_FENCE("polished_planks_fence", () -> new ModBlockItem(BlocksRegistry.POLISHED_PLANKS_FENCE.get())),
    POLISHED_PLANKS_FENCE_GATE("polished_planks_fence_gate", () -> new ModBlockItem(BlocksRegistry.POLISHED_PLANKS_FENCE_GATE.get())),
    POLISHED_WOOD_PILLAR("polished_wood_pillar", () -> new ModBlockItem(BlocksRegistry.POLISHED_WOOD_PILLAR.get())),

    /**  Items **/
    
    BONECHILL_WAND("bonechill_wand", BonechillWandItem::new),
    SOULFIRE_WAND("soulfire_wand", SoulfireWandItem::new),
    CLEAVING_AXE("cleaving_axe", CleavingAxeItem::new),
    CODEX("codex", CodexItem::new),
    REAPER_SCYTHE("reaper_scythe", ReaperScytheItem::new),
    REVERSAL_PICK("reversal_pick", ReversalPickItem::new),
    SAPPING_SWORD("sapping_sword", SappingSwortItem::new),
    TOP_HAT("top_hat", TopHatItem::new),
    UNHOLY_SYMBOL("unholy_symbol", UnholySymbolItem::new),
    WARLOCK_HAT("warlock_hat",() -> new WarlockRobesItem(EquipmentSlot.HEAD)),
    WARLOCK_CLOAK("warlock_cloak", () -> new WarlockRobesItem(EquipmentSlot.CHEST)),
    WARLOCK_BOOTS("warlock_boots", () -> new WarlockRobesItem(EquipmentSlot.FEET)),
    BASIC_AMULET("basic_amulet", BasicAmuletItem::new),
    BASIC_BELT("basic_belt", BasicBeltItem::new),
    BASIC_RING("basic_ring", BasicRingItem::new),
    GLASS_HAND("glass_hand", GlassHandItem::new),
    GRAVITY_BELT("gravity_belt", GravityBeltItem::new),
    MIND_SHIELDING_PLATE("mind_shielding_plate", MindShieldingPlateItem::new),
    PRESTIGIOUS_PALM("prestigious_palm", PrestigiousPalmItem::new),
    RESOLUTE_BELT("resolute_belt", ResoluteBeltItem::new),
    SANGUINE_AMULET("sanguine_amulet", SanguineAmuletItem::new),
    VOID_AMULET("void_amulet", VoidAmuletItem::new),
    WARDED_MAIL("warded_mail", WardedMailItem::new),

    PEWTER_INGOT("pewter_ingot"),
    PEWTER_BLEND("pewter_blend"),
    PEWTER_NUGGET("pewter_nugget"),
    PEWTER_INLAY("pewter_inlay"),
    LEAD_INGOT("lead_ingot"),
    LEAD_NUGGET("lead_nugget"),
    ARCANE_GOLD_INGOT("arcane_gold_ingot"),
    ARCANE_GOLD_NUGGET("arcane_gold_nugget"),
    SULFUR("sulfur"),
    GOLD_INLAY("gold_inlay"),
    WICKED_WEAVE("wicked_weave"),
    TATTERED_CLOTH("tattered_cloth"),
    SOUL_SHARD("soul_shard"),
    DEATH_ESSENCE("death_essence"),
    CRIMSON_ESSENCE("crimson_essence"),
    ENDER_CALX("ender_calx"),
    TALLOW("tallow"),
    LESSER_SOUL_GEM("lesser_soul_gem"),
    SHADOW_GEM("shadow_gem");

    private final String pathName;
    private final Supplier<Item> itemSupplier;
    private final Integer burnTime;
    private Item item;

    ItemsRegistry(String pathName) {
        this(pathName, () -> new Item(new ModItemSettings()));
    }

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier) {
        this(pathName, itemSupplier, null);
    }

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Integer burnTime) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.burnTime = burnTime;
    }

    public static void registerAll() {
        for (ItemsRegistry value : values()) {
            Registry.register(Registry.ITEM, new Identifier(EidolonMod.MOD_ID, value.pathName), value.get());
            if (value.burnTime != null && value.burnTime > 0) {
                FuelRegistry.INSTANCE.add(value.get(), value.burnTime);
            }
        }
    }

    public Item get() {
        if (item == null) {
            item = itemSupplier.get();
        }
        return item;
    }

    public String getId() {
        return Registry.ITEM.getId(get()).toString();
    }

}