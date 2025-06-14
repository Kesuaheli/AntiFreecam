package de.kesuaheli.antifreecam.packet;

import de.kesuaheli.antifreecam.AntiFreecam;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record FreecamConfigS2CPacket(boolean forceCollision) implements CustomPayload {
	public static final CustomPayload.Id<FreecamConfigS2CPacket> ID = new CustomPayload.Id<>(Identifier.of(AntiFreecam.MOD_ID, "freecam_config_packet"));
	public static final PacketCodec<PacketByteBuf, FreecamConfigS2CPacket> CODEC = PacketCodec.tuple(PacketCodecs.BOOLEAN, FreecamConfigS2CPacket::forceCollision, FreecamConfigS2CPacket::new);

	@Override
	public Id<? extends CustomPayload> getId() {
		return ID;
	}
}
