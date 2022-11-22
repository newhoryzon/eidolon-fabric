package com.nhoryzon.mc.eidolon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class BlockBase extends Block {

    protected VoxelShape shape = null;

    public BlockBase(Settings settings) {
        super(settings);
    }

    public BlockBase setShape(VoxelShape shape) {
        this.shape = shape;
        return this;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getRaycastShape(state, world, pos);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getRaycastShape(state, world, pos);
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return shape != null ? shape : VoxelShapes.fullCube();
    }

}
