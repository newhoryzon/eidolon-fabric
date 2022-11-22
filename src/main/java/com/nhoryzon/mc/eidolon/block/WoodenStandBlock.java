package com.nhoryzon.mc.eidolon.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BrewingStandBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class WoodenStandBlock extends BrewingStandBlock {

    protected static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(.0d, .0d, .0d, 16.d, 2.d, 16.d),
            Block.createCuboidShape(7.d, .0d, 7.d, 9.d, 14.d, 9.d));

    public WoodenStandBlock() {
        super(FabricBlockSettings.of(Material.METAL, MapColor.OAK_TAN).sounds(BlockSoundGroup.STONE).strength(2.f, 3.f).nonOpaque());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            /* TODO
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof WoodenStandTileEntity) {
                NetworkHooks.openGui((ServerPlayerEntity)player, new SimpleNamedContainerProvider((id, inventory, p) -> {
                    return new WoodenBrewingStandContainer(id, inventory, ((WoodenStandTileEntity)tileentity), ((WoodenStandTileEntity)tileentity).field_213954_a);
                }, ((WoodenStandTileEntity)tileentity).getDisplayName()), pos);
                player.addStat(Stats.INTERACT_WITH_BREWINGSTAND);
            }
            */

            return ActionResult.CONSUME;
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            /* TODO
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof WoodenStandTileEntity) {
                ((WoodenStandTileEntity)tileentity).setCustomName(stack.getDisplayName());
            }
            */
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, net.minecraft.util.math.random.Random random) {
        // no particles with this one
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            /* TODO
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof WoodenStandTileEntity) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (WoodenStandTileEntity)tileentity);
            }
            */

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

}
