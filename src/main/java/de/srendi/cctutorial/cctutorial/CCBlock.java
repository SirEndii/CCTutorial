package de.srendi.cctutorial.cctutorial;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class CCBlock extends Block {

    public CCBlock() {
        super(Properties.create(Material.IRON).hardnessAndResistance(5, 10));
    }

    //Create a new tile entity with our registry object
    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return Registration.CC_TILEENTITY.get().create();
    }

    //Say minecraft, our CCBlock has a tile entity.
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
