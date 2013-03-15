/** 
 * Copyright (C) 2011-2013 Flow86
 * 
 * EditableSigns is open-source.
 *
 * It is distributed under the terms of my Open Source License. 
 * It grants rights to read, modify, compile or run the code. 
 * It does *NOT* grant the right to redistribute this software or its 
 * modifications in any form, binary or source, except if expressively
 * granted by the copyright holder.
 */

package EditableSigns;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;

/**
 * @author Flow86
 * 
 */
public class BlockEditableSign extends BlockSign {

	protected BlockEditableSign(int i, Class class1, boolean flag) {
		super(i, class1, flag);
		disableStats();
	}

	@Override
	public boolean onBlockActivated(World worldObj, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
		if (entityplayer.isSneaking())
			return super.onBlockActivated(worldObj, x, y, z, entityplayer, par6, par7, par8, par9);

		TileEntitySign tileentitysign = (TileEntitySign) worldObj.getBlockTileEntity(x, y, z);
		if (tileentitysign != null) {
			// display GUI
			entityplayer.displayGUIEditSign(tileentitysign);
		}
		return true;
	}

	public static void initialize() {
		Block.blocksList[63] = null;
		Block.signPost = (new BlockEditableSign(63, TileEntitySign.class, true)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("sign");

		Block.blocksList[68] = null;
		Block.signWall = (new BlockEditableSign(68, TileEntitySign.class, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("sign");
	}
}
