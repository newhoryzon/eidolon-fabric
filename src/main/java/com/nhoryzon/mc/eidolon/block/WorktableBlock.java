package com.nhoryzon.mc.eidolon.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.shape.VoxelShapes;

public class WorktableBlock extends BlockBase {

    public WorktableBlock() {
        super(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD).strength(1.6f, 3.f).nonOpaque());
        setShape(VoxelShapes.union(
                VoxelShapes.cuboid(0, 0, 0, 1, .25, 1),
                VoxelShapes.cuboid(.125, .25, .125, .875, .625, .875),
                VoxelShapes.cuboid(0, .625, 0, 1, 1, 1)
        ));
    }

}
