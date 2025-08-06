package net.emmaly.metaldetectors;

import net.emmaly.metaldetectors.item.ModItems;
import net.emmaly.metaldetectors.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetalDetectors implements ModInitializer {
	public static final String MOD_ID = "metal-detectors";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModSounds.registerSounds();
	}
}