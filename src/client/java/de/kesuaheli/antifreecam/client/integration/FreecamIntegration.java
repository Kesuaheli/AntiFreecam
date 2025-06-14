package de.kesuaheli.antifreecam.client.integration;

import de.kesuaheli.antifreecam.Antifreecam;
import net.fabricmc.loader.api.FabricLoader;

public class FreecamIntegration {
	public static String MOD_ID = "freecam";

	public static void enable() {
		if (!FabricLoader.getInstance().isModLoaded(FreecamIntegration.MOD_ID)) {
			Antifreecam.LOGGER.info("Freecam Mod not installed on client.");
			return;
		}
		Antifreecam.LOGGER.info("Freecam Mod installed on client.");
	}
}
