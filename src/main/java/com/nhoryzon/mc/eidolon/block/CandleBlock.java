package com.nhoryzon.mc.eidolon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

// TODO
public class CandleBlock extends BlockBase {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(6.d, 0.d, 6.d, 10.d, 9.d, 10.d);

    public CandleBlock() {
        super(Settings.of(Material.DECORATION, MapColor.TERRACOTTA_WHITE).sounds(BlockSoundGroup.CANDLE).luminance(value -> 15)
                .strength(.6f, .8f).nonOpaque());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

}
