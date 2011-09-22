package net.minecraft.src;

public class mod_EditableSign extends BaseMod {

	public mod_EditableSign() {
		Block.blocksList[63] = null;
		Block signPost = (new BlockEditableSign(63, net.minecraft.src.TileEntitySign.class, true)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();

		Block.blocksList[68] = null;
		Block signWall = (new BlockEditableSign(68, net.minecraft.src.TileEntitySign.class, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();
		
		try {
			ModLoader.setPrivateValue(Block.class, null, "aE", signPost);
			ModLoader.setPrivateValue(Block.class, null, "aJ", signWall);
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

	public String Version() {
		return "1.8.1b";
	}
}
