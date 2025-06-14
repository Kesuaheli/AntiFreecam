package de.kesuaheli.antifreecam;

import de.kesuaheli.antifreecam.packet.FreecamConfigS2CPacket;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerConfigurationNetworking;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AntiFreecam implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger(AntiFreecam.class);
	public static final String MOD_ID = "antifreecam";

	@Override
	public void onInitialize() {
		PayloadTypeRegistry.configurationS2C().register(FreecamConfigS2CPacket.ID, FreecamConfigS2CPacket.CODEC);
	}
}
