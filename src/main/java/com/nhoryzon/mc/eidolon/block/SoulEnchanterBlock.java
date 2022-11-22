package com.nhoryzon.mc.eidolon.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.shape.VoxelShapes;

public class SoulEnchanterBlock extends HorizontalBlockBase {

    public SoulEnchanterBlock() {
        super(FabricBlockSettings.of(Material.STONE, MapColor.STONE_GRAY).sounds(BlockSoundGroup.STONE).strength(2.8f, 3.f)
                .requiresTool().nonOpaque());
        setShape(VoxelShapes.cuboid(0, 0, 0, 1, .75, 1));
    }

}
