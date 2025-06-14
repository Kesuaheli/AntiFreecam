package de.kesuaheli.antifreecam.client;

import de.kesuaheli.antifreecam.AntiFreecam;
import de.kesuaheli.antifreecam.client.integration.FreecamIntegration;
import de.kesuaheli.antifreecam.packet.FreecamConfigS2CPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientConfigurationNetworking;
import org.slf4j.Logger;

public class AntiFreecamClient implements ClientModInitializer {
	public final Logger LOGGER = AntiFreecam.LOGGER;

	@Override
	public void onInitializeClient() {
		FreecamIntegration.enable();

		ClientConfigurationNetworking.registerGlobalReceiver(FreecamConfigS2CPacket.ID, (payload, context) -> {
			FreecamIntegration.forceCollision = payload.forceCollision();
			LOGGER.info("Server config: force collisions {}", payload.forceCollision());
		});
	}
}
