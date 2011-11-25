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

	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		TileEntitySign tileentitysign = (TileEntitySign) world.getBlockTileEntity(i, j, k);
		if (tileentitysign != null) {
			entityplayer.displayGUIEditSign(tileentitysign);
		}
		return true;
	}
}
