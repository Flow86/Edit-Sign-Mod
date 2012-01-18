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

/**
 * 
 */
package net.minecraft.src;

/**
 * @author Flow86
 * 
 */
public class BlockEditableSign extends BlockSign {
	
	/**
	 * initializes the mod.
	 */
	public static void initialize() {
		Block.blocksList[63] = null;
		Block signPost = (new BlockEditableSign(63, net.minecraft.src.TileEntitySign.class, true)).setHardness(1.0F)
				.setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();

		Block.blocksList[68] = null;
		Block signWall = (new BlockEditableSign(68, net.minecraft.src.TileEntitySign.class, false)).setHardness(1.0F)
				.setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();

		try {
			ModLoader.setPrivateValue(Block.class, null, mod_EditableSign.getObfuscation()[0], signPost);
			ModLoader.setPrivateValue(Block.class, null, mod_EditableSign.getObfuscation()[1], signWall);
		} catch (Exception e) {
			//e.printStackTrace();
			try {
				ModLoader.setPrivateValue(Block.class, null, "signPost", signPost);
				ModLoader.setPrivateValue(Block.class, null, "signWall", signWall);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static String getVersion() {
		return "1.4 (MC 1.1) MP";
	}
	
	protected BlockEditableSign(int i, Class class1, boolean flag) {
		super(i, class1, flag);
	}

	@Override
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		mod_EditableSign.displayGUIEditSign(world,i, j, k, entityplayer);
		return true;
	}
}
