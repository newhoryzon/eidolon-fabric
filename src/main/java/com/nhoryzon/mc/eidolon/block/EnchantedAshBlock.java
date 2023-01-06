package com.nhoryzon.mc.eidolon.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.EntityShapeContext;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.WireConnection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class EnchantedAshBlock extends BlockBase {

    public static final EnumProperty<WireConnection> NORTH = Properties.NORTH_WIRE_CONNECTION;
    public static final EnumProperty<WireConnection> EAST = Properties.EAST_WIRE_CONNECTION;
    public static final EnumProperty<WireConnection> SOUTH = Properties.SOUTH_WIRE_CONNECTION;
    public static final EnumProperty<WireConnection> WEST = Properties.WEST_WIRE_CONNECTION;
    public static final Map<Direction, EnumProperty<WireConnection>> FACING_PROPERTY_MAP = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, NORTH,
            Direction.EAST, EAST,
            Direction.SOUTH, SOUTH,
            Direction.WEST, WEST
    ));

    private static final VoxelShape BARRIER_SHAPE = VoxelShapes.cuboid(0, -4, 0, 1, 5, 1);

    private static final VoxelShape BASE_SHAPE = Block.createCuboidShape(3.d, 0.d, 3.d, 13.d, 1.d, 13.d);

    private static final Map<Direction, VoxelShape> SIDE_TO_SHAPE = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Block.createCuboidShape(3.d, 0.d, 0.d, 13.d, 1.d, 13.d),
            Direction.SOUTH, Block.createCuboidShape(3.d, 0.d, 3.d, 13.d, 1.d, 16.d),
            Direction.EAST, Block.createCuboidShape(3.d, 0.d, 3.d, 16.d, 1.d, 13.d),
            Direction.WEST, Block.createCuboidShape(0.d, 0.d, 3.d, 13.d, 1.d, 13.d)
    ));

    private static final Map<Direction, VoxelShape> SIDE_TO_ASCENDING_SHAPE = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, VoxelShapes.union(SIDE_TO_SHAPE.get(Direction.NORTH), Block.createCuboidShape(3.d, 0.d, 0.d, 13.d, 16.d, 1.d)),
            Direction.SOUTH, VoxelShapes.union(SIDE_TO_SHAPE.get(Direction.SOUTH), Block.createCuboidShape(3.d, 0.d, 15.d, 13.d, 16.d, 16.d)),
            Direction.EAST, VoxelShapes.union(SIDE_TO_SHAPE.get(Direction.EAST), Block.createCuboidShape(15.d, 0.d, 3.d, 16.d, 16.d, 13.d)),
            Direction.WEST, VoxelShapes.union(SIDE_TO_SHAPE.get(Direction.WEST), Block.createCuboidShape(0.d, 0.d, 3.d, 1.d, 16.d, 13.d))
    ));

    private final Map<BlockState, VoxelShape> stateToShapeMap = Maps.newHashMap();

    private final BlockState sideBaseState;

    public EnchantedAshBlock() {
        super(Settings.of(Material.DECORATION, MapColor.TERRACOTTA_WHITE).sounds(BlockSoundGroup.STONE).strength(.0f, .75f).nonOpaque());

        setDefaultState(getStateManager().getDefaultState()
                .with(NORTH, WireConnection.NONE).with(SOUTH, WireConnection.NONE).with(EAST, WireConnection.NONE).with(WEST, WireConnection.NONE));
        sideBaseState = getDefaultState()
                .with(NORTH, WireConnection.SIDE).with(SOUTH, WireConnection.SIDE).with(EAST, WireConnection.SIDE).with(WEST, WireConnection.SIDE);

        for(BlockState blockState : getStateManager().getStates()) {
            stateToShapeMap.put(blockState, getShapeForState(blockState));
        }
        setShape(VoxelShapes.empty());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return stateToShapeMap.get(state);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getUpdatedState(ctx.getWorld(), sideBaseState, ctx.getBlockPos());
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world,
            BlockPos pos, BlockPos neighborPos) {
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!oldState.isOf(state.getBlock()) && !world.isClient) {
            for(Direction direction : Direction.Type.VERTICAL) {
                world.updateNeighbors(pos.offset(direction), this);
            }

            updateNeighboursStateChange(world, pos);
        }
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        super.onEntityCollision(state, world, pos, entity);
    }

    /* TODO: Add Mixin event
    @Override
    public boolean collisionExtendsVertically(BlockState state, IBlockReader world, BlockPos pos, Entity entity) {
        return entity instanceof LivingEntity && ((LivingEntity)entity).isEntityUndead();
    }
    */

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return context instanceof EntityShapeContext ctxEntity && isBlocked(ctxEntity.getEntity()) ? BARRIER_SHAPE
                : super.getCollisionShape(state, world, pos, context);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockpos = pos.down();

        return canPlaceOnTopOf(world, blockpos, world.getBlockState(blockpos));
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!moved && !state.isOf(newState.getBlock())) {
            super.onStateReplaced(state, world, pos, newState, false);
            if (!world.isClient) {
                for(Direction direction : Direction.values()) {
                    world.updateNeighbors(pos.offset(direction), this);
                }

                updateNeighboursStateChange(world, pos);
            }
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            if (!state.canPlaceAt(world, pos)) {
                Block.dropStacks(state, world, pos);
                world.removeBlock(pos, false);
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.PASS;
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return false;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        // no particles with this one
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST);
    }

    private VoxelShape getShapeForState(BlockState state) {
        VoxelShape voxelShape = BASE_SHAPE;

        for (Direction direction : Direction.Type.HORIZONTAL) {
            WireConnection wireConnection = state.get(FACING_PROPERTY_MAP.get(direction));
            if (wireConnection == WireConnection.SIDE) {
                voxelShape = VoxelShapes.union(voxelShape, SIDE_TO_SHAPE.get(direction));
            } else if (wireConnection == WireConnection.UP) {
                voxelShape = VoxelShapes.union(voxelShape, SIDE_TO_ASCENDING_SHAPE.get(direction));
            }
        }

        return voxelShape;
    }

    private BlockState getUpdatedState(WorldView world, BlockState state, BlockPos pos) {
        boolean flag = areAllSidesInvalid(state);
        state = recalculateFacingState(world, getDefaultState(), pos);
        if (!flag || !areAllSidesInvalid(state)) {
            boolean flag1 = state.get(NORTH).isConnected();
            boolean flag2 = state.get(SOUTH).isConnected();
            boolean flag3 = state.get(EAST).isConnected();
            boolean flag4 = state.get(WEST).isConnected();
            boolean flag5 = !flag1 && !flag2;
            boolean flag6 = !flag3 && !flag4;
            if (!flag4 && flag5) {
                state = state.with(WEST, WireConnection.SIDE);
            }

            if (!flag3 && flag5) {
                state = state.with(EAST, WireConnection.SIDE);
            }

            if (!flag1 && flag6) {
                state = state.with(NORTH, WireConnection.SIDE);
            }

            if (!flag2 && flag6) {
                state = state.with(SOUTH, WireConnection.SIDE);
            }

        }

        return state;
    }

    private boolean areAllSidesInvalid(BlockState state) {
        return !state.get(NORTH).isConnected() && !state.get(SOUTH).isConnected() && !state.get(EAST).isConnected() && !state.get(WEST).isConnected();
    }

    private boolean areAllSidesValid(BlockState state) {
        return state.get(NORTH).isConnected() && state.get(SOUTH).isConnected() && state.get(EAST).isConnected() && state.get(WEST).isConnected();
    }

    private BlockState recalculateFacingState(WorldView world, BlockState state, BlockPos pos) {
        boolean flag = !world.getBlockState(pos.up()).isSolidBlock(world, pos);

        for(Direction direction : Direction.Type.HORIZONTAL) {
            if (!state.get(FACING_PROPERTY_MAP.get(direction)).isConnected()) {
                state = state.with(FACING_PROPERTY_MAP.get(direction), recalculateSide(world, pos, direction, flag));
            }
        }

        return state;
    }

    private void updateNeighboursStateChange(World world, BlockPos pos) {
        for(Direction direction : Direction.Type.HORIZONTAL) {
            notifyWireNeighborsOfStateChange(world, pos.offset(direction));
        }

        for(Direction direction1 : Direction.Type.HORIZONTAL) {
            BlockPos blockpos = pos.offset(direction1);
            if (world.getBlockState(blockpos).isSolidBlock(world, blockpos)) {
                notifyWireNeighborsOfStateChange(world, blockpos.up());
            } else {
                notifyWireNeighborsOfStateChange(world, blockpos.down());
            }
        }
    }

    private void notifyWireNeighborsOfStateChange(World world, BlockPos pos) {
        if (world.getBlockState(pos).isOf(this)) {
            world.updateNeighbors(pos, this);

            for(Direction direction : Direction.values()) {
                world.updateNeighbors(pos.offset(direction), this);
            }
        }
    }

    private boolean isBlocked(Entity entity) {
        if (entity == null) {
            return false;
        }

        if (entity instanceof LivingEntity livingEntity && livingEntity.isUndead()) {
            return true;
        }

        return entity.getPassengerList().stream().anyMatch((e) -> e instanceof LivingEntity && ((LivingEntity) e).isUndead());
    }

    private WireConnection getSide(WorldView world, BlockPos pos, Direction face) {
        return recalculateSide(world, pos, face, !world.getBlockState(pos.up()).isSolidBlock(world, pos));
    }

    private WireConnection recalculateSide(WorldView world, BlockPos pos, Direction direction, boolean nonNormalCubeAbove) {
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);

        if (nonNormalCubeAbove) {
            boolean flag = canPlaceOnTopOf(world, blockPos, blockState);
            if (flag && world.getBlockState(blockPos.up()).isOf(this)) {
                if (blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
                    return WireConnection.UP;
                }

                return WireConnection.SIDE;
            }
        }

        return !blockState.isOf(this) && (blockState.isSolidBlock(world, blockPos)
                || !world.getBlockState(blockPos.down()).isOf(this)) ? WireConnection.NONE : WireConnection.SIDE;
    }

    private boolean canPlaceOnTopOf(WorldView world, BlockPos pos, BlockState state) {
        return state.isSideSolidFullSquare(world, pos, Direction.UP);
    }

}
