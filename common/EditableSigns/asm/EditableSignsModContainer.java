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

import java.util.Arrays;
import java.util.logging.Logger;

import EditableSigns.BlockEditableSign;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class EditableSignsModContainer extends DummyModContainer {
	public static Logger esLog = Logger.getLogger("Editable-Signs");

	public EditableSignsModContainer() {
		super(new ModMetadata());

		ModMetadata myMeta = super.getMetadata();
		myMeta.authorList = Arrays.asList(new String[] { "Flow86" });
		myMeta.description = "make signs editable";
		myMeta.modId = "Editable-Signs";
		myMeta.version = "@ES_VERSION@";
		myMeta.name = "Editable Signs";
		myMeta.url = "http://www.minecraftforum.net/index.php?app=forums&module=forums&section=findpost&pid=8436662";
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}

	@Subscribe
	public void load(FMLInitializationEvent evt) {
		esLog.setParent(FMLLog.getLogger());
		esLog.info("Starting EditableSigns #@BUILD_NUMBER@ " + super.getMetadata().version + " (Built for Minecraft @MINECRAFT_VERSION@ with Forge @FORGE_VERSION@");
		esLog.info("Copyright (c) Flow86, 2011-2013");

		BlockEditableSign.initialize();
	}
}
