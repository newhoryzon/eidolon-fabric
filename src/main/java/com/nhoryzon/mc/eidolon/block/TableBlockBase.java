package com.nhoryzon.mc.eidolon.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class TableBlockBase extends BlockBaseWaterloggable {


    private static final BooleanProperty
            NX = BooleanProperty.of("nx"),
            PX = BooleanProperty.of("px"),
            NZ = BooleanProperty.of("nz"),
            PZ = BooleanProperty.of("pz");

    private final VoxelShape base;
    private final VoxelShape corner;

    public TableBlockBase(Settings settings) {
        this(settings, VoxelShapes.cuboid(0, .75, 0, 1, 1, 1));
    }

    public TableBlockBase(Settings settings, VoxelShape baseShape) {
        super(settings);
        base = baseShape;
        corner = VoxelShapes.combine(base,
                VoxelShapes.cuboid(.0625, 0, .0625, .9375, .75, .9375), BooleanBiFunction.OR);
        setDefaultState(getStateManager().getDefaultState()
                .with(NX, false).with(PX, false).with(NZ, false).with(PZ, false));
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        boolean nx = state.get(NX), px = state.get(PX), nz = state.get(NZ), pz = state.get(PZ);

        return (!nx && !nz) || (!nx && !pz) || (!px && !pz) || (!px && !nz) ? corner : base;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState superState = super.getPlacementState(ctx);
        return updateCorners(ctx.getWorld(), ctx.getBlockPos(), superState == null ? getDefaultState() : superState);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world,
            BlockPos pos, BlockPos neighborPos) {
        super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);

        return updateCorners(world, pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(NX, PX, NZ, PZ);
    }

    protected BlockState updateCorners(WorldView world, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos.north());
        BlockState blockState1 = world.getBlockState(pos.east());
        BlockState blockState2 = world.getBlockState(pos.south());
        BlockState blockState3 = world.getBlockState(pos.west());
        boolean conn1 = blockState.getBlock() == this,
                conn2 = blockState1.getBlock() == this,
                conn3 = blockState2.getBlock() == this,
                conn4 = blockState3.getBlock() == this;
        return state
                .with(NZ, conn1).with(PX, conn2)
                .with(PZ, conn3).with(NX, conn4);
    }

}
