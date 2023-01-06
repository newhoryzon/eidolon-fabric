package com.nhoryzon.mc.eidolon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CandlestickBlock extends BlockBase {

    protected static final DirectionProperty FACING = DirectionProperty.of("facing", direction -> direction != Direction.DOWN);

    protected static final VoxelShape UP_SHAPE = Block.createCuboidShape(6.d, 0.d, 6.d, 10.d, 14.d, 10.d);
    
    private static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.createCuboidShape(5.5d, 3.0d, 11.0d, 10.5d, 16.0d, 16.0d),
            Block.createCuboidShape(5.5d, 3.0d, 0.0d, 10.5d, 16.0d, 5.0d),
            Block.createCuboidShape(11.0d, 3.0d, 5.5d, 16.0d, 16.0d, 10.5d),
            Block.createCuboidShape(0.0d, 3.0d, 5.5d, 5.0d, 16.0d, 10.5d)};

    public CandlestickBlock() {
        super(Settings.of(Material.METAL, MapColor.GOLD).sounds(BlockSoundGroup.STONE).luminance(value -> 15).strength(1.2f, 2.f).nonOpaque());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        return dir == Direction.UP ? UP_SHAPE : SHAPES[dir.ordinal() - 2];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);

        return blockState.isSideSolidFullSquare(world, blockPos, direction);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world,
            BlockPos pos, BlockPos neighborPos) {
        Direction facing = state.get(FACING);
        if (facing == Direction.UP) {
            return direction == Direction.DOWN && !canPlaceAt(state, world, pos) ? Blocks.AIR.getDefaultState()
                    : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        } else {
            return direction.getOpposite() == state.get(FACING) && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : state;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = this.getDefaultState();
        WorldView world = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction[] placementDirections = ctx.getPlacementDirections();

        for(Direction direction : placementDirections) {
            if (direction != Direction.UP) {
                Direction direction1 = direction.getOpposite();
                blockState = blockState.with(FACING, direction1);
                if (blockState.canPlaceAt(world, blockPos)) {
                    return blockState;
                }
            }
        }

        return null;
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction facing = state.get(FACING);
        double d0 = (double) pos.getX() + 0.5D;
        double d1 = (double) pos.getY() + 0.925D;
        double d2 = (double) pos.getZ() + 0.5D;
        if (facing != Direction.UP) {
            d0 -= .3 * facing.getOffsetX();
            d1 += .125;
            d2 -= .3 * facing.getOffsetZ();
        }
        world.addParticle(ParticleTypes.SMOKE, d0, d1, d2, .0d, .0d, .0d);
        world.addParticle(ParticleTypes.FLAME, d0, d1, d2, .0d, .0d, .0d);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.get(FACING) != Direction.UP ? state.with(FACING, rotation.rotate(state.get(FACING))) : state;
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.get(FACING) != Direction.UP ? state.rotate(mirror.getRotation(state.get(FACING))) : state;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
