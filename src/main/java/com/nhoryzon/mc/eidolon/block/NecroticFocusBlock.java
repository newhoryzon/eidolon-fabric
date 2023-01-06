package com.nhoryzon.mc.eidolon.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Map;

public class NecroticFocusBlock extends HorizontalWaterloggableBlock {

    private static final Map<Direction, VoxelShape> SHAPES = Map.of(
            Direction.SOUTH, VoxelShapes.cuboid(0, 0, 0, 1, 1, .5),
            Direction.NORTH, VoxelShapes.cuboid(0, 0, .5, 1, 1, 1),
            Direction.WEST, VoxelShapes.cuboid(.5, 0, 0, 1, 1, 1),
            Direction.EAST, VoxelShapes.cuboid(0, 0, 0, .5, 1, 1)
    );

    public NecroticFocusBlock() {
        super(Settings.of(Material.STONE, MapColor.STONE_GRAY));
        setShape(VoxelShapes.cuboid(.25, 0, .25, .75, .75, .75));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShapeForState(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return getShapeForState(state);
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return getShapeForState(state);
    }

    private VoxelShape getShapeForState(BlockState state) {
        return SHAPES.getOrDefault(state.get(HORIZONTAL_FACING), SHAPES.get(Direction.EAST));
    }

}
