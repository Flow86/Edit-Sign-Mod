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

package net.minecraft.src;

public class mod_EditableSign extends BaseMod {

	public mod_EditableSign() {
	}

	@Override
	public void load() {
		Block.blocksList[63] = null;
		Block signPost = (new BlockEditableSign(63, net.minecraft.src.TileEntitySign.class, true)).setHardness(1.0F)
				.setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();

		Block.blocksList[68] = null;
		Block signWall = (new BlockEditableSign(68, net.minecraft.src.TileEntitySign.class, false)).setHardness(1.0F)
				.setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();

		try {
			ModLoader.setPrivateValue(Block.class, null, "aD", signPost);
			ModLoader.setPrivateValue(Block.class, null, "aI", signWall);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ModLoader.setPrivateValue(Block.class, null, "signPost", signPost);
				ModLoader.setPrivateValue(Block.class, null, "signWall", signWall);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public String getVersion() {
		return "1.2 (MC 1.0.0)";
	}
}
