package net.minecraft.src;

public class mod_EditableSign extends BaseMod {

	public mod_EditableSign() {
		Block.blocksList[63] = null;
		Block signPost = (new BlockEditableSign(63, net.minecraft.src.TileEntitySign.class, true)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();

		Block.blocksList[68] = null;
		Block signWall = (new BlockEditableSign(68, net.minecraft.src.TileEntitySign.class, false)).setHardness(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("sign").disableStats().setRequiresSelfNotify();
		
		try {
			ModLoader.setPrivateValue(Block.class, null, "signPost", signPost);
			ModLoader.setPrivateValue(Block.class, null, "signWall", signWall);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String Version() {
		return "1.8.1b";
	}
}
