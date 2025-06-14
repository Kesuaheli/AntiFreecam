package de.kesuaheli.antifreecam.server;

import de.kesuaheli.antifreecam.AntiFreecam;
import de.kesuaheli.antifreecam.packet.FreecamConfigS2CPacket;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationNetworking;
import net.minecraft.text.Text;

public class AntiFreecamServer implements DedicatedServerModInitializer {
	/**
	 * Runs the mod initializer on the server environment.
	 */
	@Override
	public void onInitializeServer() {
		AntiFreecam.LOGGER.info("AntiFreecam loaded!");

		ServerConfigurationConnectionEvents.CONFIGURE.register((handler, server) -> {
			if (!ServerConfigurationNetworking.canSend(handler, FreecamConfigS2CPacket.ID)) {
				handler.disconnect(Text.literal("This Server requires the AntiFreecam mod to be installed."));
				return;
			}
			ServerConfigurationNetworking.send(handler, new FreecamConfigS2CPacket(true));
			AntiFreecam.LOGGER.info("A player with AntiFreecam connects to the server...");
		});
	}
}
