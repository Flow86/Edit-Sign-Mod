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

package EditableSigns.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.FMLInjectionData;
import cpw.mods.fml.relauncher.IFMLCallHook;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
// import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

@TransformerExclusions(value = { "EditableSigns.asm" })
// @MCVersion(value = "@MINECRAFT_VERSION@")
public class EditableSignsLoadingPlugin implements IFMLLoadingPlugin, IFMLCallHook {

	@Override
	public String[] getLibraryRequestClass() {
		return null;
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[] { "EditableSigns.asm.EditableSignsAccessTransformer" };
	}

	@Override
	public String getModContainerClass() {
		return "EditableSigns.asm.EditableSignsModContainer";
	}

	@Override
	public String getSetupClass() {
		return "EditableSigns.asm.EditableSignsLoadingPlugin";
	}

	@Override
	public void injectData(Map<String, Object> data) {
	}

	@Override
	public Void call() throws Exception {
		EditableSignsAccessTransformer.addTransformerMap("editablesigns_at_" + FMLInjectionData.data()[4]/* MCVersion */+ ".cfg");
		return null;
	}
}
