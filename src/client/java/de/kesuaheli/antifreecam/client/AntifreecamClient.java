package de.kesuaheli.antifreecam.client;

import de.kesuaheli.antifreecam.Antifreecam;
import de.kesuaheli.antifreecam.packet.FreecamConfigS2CPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientConfigurationNetworking;
import org.slf4j.Logger;

public class AntifreecamClient implements ClientModInitializer {
	public final Logger LOGGER = Antifreecam.LOGGER;

	@Override
	public void onInitializeClient() {
		ClientConfigurationNetworking.registerGlobalReceiver(FreecamConfigS2CPacket.ID, (payload, context) -> {
			LOGGER.info("Server config: force collisions {}", payload.forceCollision());
		});

		LOGGER.info("Loaded AntiFreecam for Client");
	}
}
