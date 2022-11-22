package com.nhoryzon.mc.eidolon.block;

import com.nhoryzon.mc.eidolon.registry.BlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.tick.OrderedTick;
import org.jetbrains.annotations.Nullable;

public class PlinthBlockBase extends BlockBase implements Waterloggable {

    public static final BooleanProperty TOP = BooleanProperty.of("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.of("bottom");
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public PlinthBlockBase() {
        super(Settings.of(Material.STONE, MapColor.STONE_GRAY).sounds(BlockSoundGroup.STONE).strength(2.f, 3.f)
                .requiresTool().nonOpaque());
        setShape(VoxelShapes.cuboid(.25, 0, .25, .75, 1, .75));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return !state.get(WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getState(ctx.getWorld(), ctx.getBlockPos());
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world,
            BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (direction == Direction.UP) {
            state = state.with(TOP, canConnectTo(world, pos.up(), Direction.UP));
        }
        if (direction == Direction.DOWN) {
            state = state.with(BOTTOM, canConnectTo(world, pos.down(), Direction.DOWN));
        }

        return state;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TOP, BOTTOM, WATERLOGGED);
    }

    protected BlockState getState(World world, BlockPos pos) {
        return this.getDefaultState()
                .with(TOP, canConnectTo(world, pos.up(), Direction.UP))
                .with(BOTTOM, canConnectTo(world, pos.down(), Direction.DOWN))
                .with(WATERLOGGED, world.getFluidState(pos).getFluid() == Fluids.WATER);
    }

    protected boolean canConnectTo(WorldAccess world, BlockPos pos, Direction dir) {
        BlockState state = world.getBlockState(pos);

        return (state.getBlock() instanceof PlinthBlockBase && dir.getAxis() == Direction.Axis.Y)
                || (dir == Direction.UP && state.getBlock() == BlocksRegistry.STONE_HAND.get());
    }

}
