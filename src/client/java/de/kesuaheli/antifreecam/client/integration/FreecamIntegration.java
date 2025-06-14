package de.kesuaheli.antifreecam.client.integration;

import de.kesuaheli.antifreecam.AntiFreecam;
import net.fabricmc.loader.api.FabricLoader;

public class FreecamIntegration {
	public static String MOD_ID = "freecam";
	private static boolean fetched = false;
	private static boolean freecamPresent;

	public static boolean forceCollision = true;

	public static void enable() {
		if (!isFreecamPresent()) {
			AntiFreecam.LOGGER.info("Freecam Mod not installed on client.");
			return;
		}
		AntiFreecam.LOGGER.info("Freecam Mod installed on client.");
	}

	public static boolean fetchFreecam() {
		freecamPresent = FabricLoader.getInstance().isModLoaded(FreecamIntegration.MOD_ID);
		fetched = true;
		return freecamPresent;
	}

	public static boolean isFreecamPresent() {
		if (fetched) return freecamPresent;
		return fetchFreecam();
	}
}
