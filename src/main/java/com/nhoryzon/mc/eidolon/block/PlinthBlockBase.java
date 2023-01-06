package com.nhoryzon.mc.eidolon.block;

import com.nhoryzon.mc.eidolon.registry.BlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class PlinthBlockBase extends BlockBaseWaterloggable {

    public static final BooleanProperty TOP = BooleanProperty.of("top");
    public static final BooleanProperty BOTTOM = BooleanProperty.of("bottom");

    public PlinthBlockBase() {
        super(Settings.of(Material.STONE, MapColor.STONE_GRAY).sounds(BlockSoundGroup.STONE).strength(2.f, 3.f)
                .requiresTool().nonOpaque());
        setShape(VoxelShapes.cuboid(.25, 0, .25, .75, 1, .75));
        setDefaultState(getStateManager().getDefaultState().with(TOP, true).with(BOTTOM, true));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        BlockState superState = super.getPlacementState(ctx);
        return (superState == null ? getDefaultState() : superState)
                .with(TOP, canConnectTo(world, pos.up(), Direction.UP))
                .with(BOTTOM, canConnectTo(world, pos.down(), Direction.DOWN));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world,
            BlockPos pos, BlockPos neighborPos) {
        state = super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);

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
        super.appendProperties(builder);
        builder.add(TOP, BOTTOM);
    }

    protected boolean canConnectTo(WorldAccess world, BlockPos pos, Direction dir) {
        BlockState state = world.getBlockState(pos);

        return (state.getBlock() instanceof PlinthBlockBase && dir.getAxis() == Direction.Axis.Y)
                || (dir == Direction.UP && state.getBlock() == BlocksRegistry.STONE_HAND.get());
    }

}
