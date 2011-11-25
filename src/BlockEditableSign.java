/** 
 * Copyright (C) 2011 Flow86
 * 
 * AdditionalBuildcraftObjects is open-source.
 *
 * It is distributed under the terms of my Open Source License. 
 * It grants rights to read, modify, compile or run the code. 
 * It does *NOT* grant the right to redistribute this software or its 
 * modifications in any form, binary or source, except if expressively
 * granted by the copyright holder.
 */

/**
 * 
 */
package net.minecraft.src;

/**
 * @author sifldoer
 * 
 */
public class BlockEditableSign extends BlockSign {

	protected BlockEditableSign(int i, Class class1, boolean flag) {
		super(i, class1, flag);
	}

	@Override
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		TileEntitySign tileentitysign = (TileEntitySign) world.getBlockTileEntity(i, j, k);
		if (tileentitysign != null) {
			entityplayer.displayGUIEditSign(tileentitysign);
		}
		return true;
	}
}
