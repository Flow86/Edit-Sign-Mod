/** 
 * Copyright (C) 2011 Flow86
 * 
 * EditableSigns is open-source.
 *
 * It is distributed under the terms of my Open Source License. 
 * It grants rights to read, modify, compile or run the code. 
 * It does *NOT* grant the right to redistribute this software or its 
 * modifications in any form, binary or source, except if expressively
 * granted by the copyright holder.
 */

package net.minecraft.src;

/**
 * @author Flow86
 * 
 */
public class mod_EditableSign extends BaseModMp {

	public mod_EditableSign() {
		BlockEditableSign.initialize();
	}

	public static String[] getObfuscation() {
		return new String[] { "aF", "aK" };
	}

	@Override
	public String Version() {
		return BlockEditableSign.getVersion();
	}

	public static void displayGUIEditSign(World world, int i, int j, int k, EntityPlayer entityplayer) {
		TileEntitySign tileentitysign = (TileEntitySign) world.getBlockTileEntity(i, j, k);
		if (tileentitysign != null) {
			
			// make it editable again (its false if chunk was loaded from NBT)
			try {
				ModLoader.setPrivateValue(TileEntitySign.class, tileentitysign, "isEditable", true);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
			
			// display GUI (not necessary on server)
			// entityplayer.displayGUIEditSign(tileentitysign);
		}
	}
}
