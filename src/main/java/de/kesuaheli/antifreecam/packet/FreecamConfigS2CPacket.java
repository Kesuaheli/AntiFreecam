package de.kesuaheli.antifreecam.packet;

import de.kesuaheli.antifreecam.AntiFreecam;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public record FreecamConfigS2CPacket(boolean forceCollision) implements CustomPacketPayload {
	public static final CustomPacketPayload.Type<FreecamConfigS2CPacket> ID = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath(AntiFreecam.MOD_ID, "freecam_config_packet"));
	public static final StreamCodec<FriendlyByteBuf, FreecamConfigS2CPacket> CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, FreecamConfigS2CPacket::forceCollision, FreecamConfigS2CPacket::new);

	@Override
	public @NonNull Type<? extends CustomPacketPayload> type() {
		return ID;
	}
}
