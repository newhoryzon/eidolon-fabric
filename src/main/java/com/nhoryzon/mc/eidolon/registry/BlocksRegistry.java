package com.nhoryzon.mc.eidolon.registry;

import com.nhoryzon.mc.eidolon.EidolonMod;
import com.nhoryzon.mc.eidolon.block.BlockBase;
import com.nhoryzon.mc.eidolon.block.CandleBlock;
import com.nhoryzon.mc.eidolon.block.CandlestickBlock;
import com.nhoryzon.mc.eidolon.block.EnchantedAshBlock;
import com.nhoryzon.mc.eidolon.block.HorizontalWaterloggableBlock;
import com.nhoryzon.mc.eidolon.block.NecroticFocusBlock;
import com.nhoryzon.mc.eidolon.block.PlinthBlockBase;
import com.nhoryzon.mc.eidolon.block.SoulEnchanterBlock;
import com.nhoryzon.mc.eidolon.block.TableBlockBase;
import com.nhoryzon.mc.eidolon.block.WoodenStandBlock;
import com.nhoryzon.mc.eidolon.block.WorktableBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShapes;

import java.util.function.Supplier;

public enum BlocksRegistry {

    LEAD_ORE("lead_ore", () -> new Block(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.8f, 3.f).requiresTool())),
    LEAD_BLOCK("lead_block", () -> new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_PURPLE)
            .sounds(BlockSoundGroup.METAL).strength(3.f).requiresTool())),
    PEWTER_BLOCK("pewter_block", () -> new Block(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_GRAY)
            .sounds(BlockSoundGroup.METAL).strength(4.f).requiresTool())),
    ARCANE_GOLD_BLOCK("arcane_gold_block", () -> new Block(FabricBlockSettings.of(Material.STONE, MapColor.GOLD)
            .sounds(BlockSoundGroup.METAL).strength(3.f, 4.f).requiresTool())),
    WOODEN_ALTAR("wooden_altar", () -> new TableBlockBase(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
            .sounds(BlockSoundGroup.WOOD).strength(1.6f, 3.f))),
    STONE_ALTAR("stone_altar", () -> new TableBlockBase(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.8f, 3.f).requiresTool().nonOpaque(),
            VoxelShapes.union(
                    VoxelShapes.cuboid(0, .375, 0, 1, 1, 1),
                    VoxelShapes.cuboid(.0625, .125, .0625, .9375, .375, .9375))), true),
    CANDLE("candle", CandleBlock::new, true),
    CANDLESTICK("candlestick", CandlestickBlock::new, true),
    STRAW_EFFIGY("straw_effigy", () -> new HorizontalWaterloggableBlock(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW)
            .sounds(BlockSoundGroup.WOOD).strength(1.4f, 2.f).nonOpaque())
            .setShape(VoxelShapes.cuboid(.28125, 0, .28125, .71875, 1, .71875))),
    GOBLET("goblet", () -> new BlockBase(FabricBlockSettings.of(Material.METAL, MapColor.GOLD)
            .sounds(BlockSoundGroup.METAL).strength(1.4f, 2.f).requiresTool().nonOpaque())
            .setShape(VoxelShapes.cuboid(.3125, 0, .3125, .6875, .5, .6875)), true),
    UNHOLY_EFFIGY("unholy_effigy", () -> new HorizontalWaterloggableBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.8f, 3.f).requiresTool().nonOpaque())
            .setShape(VoxelShapes.cuboid(.25, 0, .25, .75, 1, .75)), true),
    WORKTABLE("worktable", WorktableBlock::new, true),
    PLINTH("plinth", PlinthBlockBase::new, true),
    BRAZIER("brazier", () -> new BlockBase(FabricBlockSettings.of(Material.WOOD, MapColor.IRON_GRAY)
            .sounds(BlockSoundGroup.METAL).strength(2.5f, 3.f).nonOpaque())
            .setShape(VoxelShapes.cuboid(.1875, 0, .1875, .8125, .75, .8125))),
    CRUCIBLE("crucible", () -> new BlockBase(FabricBlockSettings.of(Material.METAL, MapColor.IRON_GRAY)
            .sounds(BlockSoundGroup.METAL).strength(4.f, 3.f).requiresTool().nonOpaque())
            .setShape(VoxelShapes.union(
                    VoxelShapes.cuboid(.0625, .875, .0625, .1875, 1, .9375),
                    VoxelShapes.cuboid(.8125, .875, .0625, .9375, 1, .9375),
                    VoxelShapes.cuboid(.0625, .875, .0625, .9375, 1, .1875),
                    VoxelShapes.cuboid(.0625, .875, .8125, .9375, 1, .9375),
                    VoxelShapes.cuboid(0, .125, 0, .125, .875, 1),
                    VoxelShapes.cuboid(.875, .125, 0, 1, .875, 1),
                    VoxelShapes.cuboid(0, .125, 0, 1, .875, .125),
                    VoxelShapes.cuboid(0, .125, .875, 1, .875, 1),
                    VoxelShapes.cuboid(.0625, 0, .0625, .9375, .125, .9375)
            )), true),
    STONE_HAND("stone_hand", () -> new HorizontalWaterloggableBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool().nonOpaque())
            .setShape(VoxelShapes.cuboid(.25, 0, .25, .75, .75, .75)), true),
    ENCHANTED_ASH("enchanted_ash", EnchantedAshBlock::new, true),
    NECROTIC_FOCUS("necrotic_focus", NecroticFocusBlock::new),
    SOUL_ENCHANTER("soul_enchanter", SoulEnchanterBlock::new, true),
    WOODEN_STAND("wooden_brewing_stand", WoodenStandBlock::new, true),

    SMOOTH_STONE_BRICKS("smooth_stone_bricks", () -> new Block(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool())),
    SMOOTH_STONE_BRICKS_SLAB("smooth_stone_bricks_slab", () -> new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool())),
    SMOOTH_STONE_BRICKS_STAIRS("smooth_stone_bricks_stairs", () -> new StairsBlock(SMOOTH_STONE_BRICKS.get().getDefaultState(),
            FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
                    .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool())),
    SMOOTH_STONE_BRICKS_WALL("smooth_stone_bricks_wall", () -> new WallBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool())),
    SMOOTH_STONE_TILES("smooth_stone_tiles", () -> new Block(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool())),
    SMOOTH_STONE_TILES_SLAB("smooth_stone_tiles_slab", () -> new SlabBlock(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
            .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool())),
    SMOOTH_STONE_TILES_STAIRS("smooth_stone_tiles_stairs", () -> new StairsBlock(SMOOTH_STONE_TILES.get().getDefaultState(),
            FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY)
                    .sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).requiresTool())),
    POLISHED_PLANKS("polished_planks", () -> new Block(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
            .sounds(BlockSoundGroup.WOOD).strength(1.6f, 3.f).requiresTool())),
    POLISHED_PLANKS_SLAB("polished_planks_slab", () -> new SlabBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
            .sounds(BlockSoundGroup.WOOD).strength(1.6f, 3.f).requiresTool())),
    POLISHED_PLANKS_STAIRS("polished_planks_stairs", () -> new StairsBlock(POLISHED_PLANKS.get().getDefaultState(),
            FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
                    .sounds(BlockSoundGroup.WOOD).strength(1.6f, 3.f).requiresTool())),
    POLISHED_PLANKS_FENCE("polished_planks_fence", () -> new FenceBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
            .sounds(BlockSoundGroup.WOOD).strength(1.6f, 3.f).requiresTool())),
    POLISHED_PLANKS_FENCE_GATE("polished_planks_fence_gate", () -> new FenceGateBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
            .sounds(BlockSoundGroup.WOOD).strength(1.6f, 3.f).requiresTool())),
    POLISHED_WOOD_PILLAR("polished_wood_pillar", () -> new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
            .strength(1.6f, 3.f)));

    private static FlammableBlockRegistry.Entry flammable(int burnChance, @SuppressWarnings("SameParameterValue") int spreadChance) {
        return new FlammableBlockRegistry.Entry(burnChance, spreadChance);
    }

    private static boolean isValidFlammableEntry(FlammableBlockRegistry.Entry flammableRate) {
        return flammableRate != null && flammableRate.getBurnChance() > 0 && flammableRate.getSpreadChance() > 0;
    }

    private final String pathName;
    private final Supplier<Block> blockSupplier;
    private final FlammableBlockRegistry.Entry flammableRate;
    private final boolean isCutout;
    private Block block;

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier) {
        this(pathName, blockSupplier, false, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout) {
        this(pathName, blockSupplier, isCutout, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout, FlammableBlockRegistry.Entry flammableRate) {
        this.pathName = pathName;
        this.blockSupplier = blockSupplier;
        this.flammableRate = flammableRate;
        this.isCutout = isCutout;
    }

    public static void registerAll() {
        for (BlocksRegistry value : values()) {
            Block block = value.get();
            Registry.register(Registry.BLOCK, new Identifier(EidolonMod.MOD_ID, value.pathName), block);
            if (isValidFlammableEntry(value.flammableRate)) {
                FlammableBlockRegistry.getDefaultInstance().add(block, value.flammableRate);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayer() {
        for (BlocksRegistry value : values()) {
            if (value.isCutout) {
                BlockRenderLayerMap.INSTANCE.putBlock(value.get(), RenderLayer.getCutout());
            }
        }
    }

    public Block get() {
        if (block == null) {
            block = blockSupplier.get();
        }

        return block;
    }

    public String getId() {
        return Registry.BLOCK.getId(get()).toString();
    }

}