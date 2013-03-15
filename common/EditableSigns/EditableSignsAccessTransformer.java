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

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import cpw.mods.fml.common.asm.transformers.AccessTransformer;

public class EditableSignsAccessTransformer extends AccessTransformer {
	private static EditableSignsAccessTransformer instance;
	private static List<String> mapFileList = new LinkedList<String>();

	public EditableSignsAccessTransformer() throws IOException {
		super();
		instance = this;
		for (String file : mapFileList)
			readMapFile(file);

		mapFileList = null;
	}

	public static void addTransformerMap(String mapFile) {
		if (instance == null)
			mapFileList.add(mapFile);
		else
			instance.readMapFile(mapFile);
	}

	private void readMapFile(String mapFile) {
		System.out.println("Adding Accesstransformer map: " + mapFile);
		try {
			Method parentMapFile = AccessTransformer.class.getDeclaredMethod("readMapFile", String.class);
			parentMapFile.setAccessible(true);
			parentMapFile.invoke(this, mapFile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
