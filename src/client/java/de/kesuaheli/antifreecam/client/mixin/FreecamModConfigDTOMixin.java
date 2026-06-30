package de.kesuaheli.antifreecam.client.mixin;

import de.kesuaheli.antifreecam.client.integration.FreecamIntegration;
import net.minecraft.world.level.block.Block;
import net.xolt.freecam.config.model.ModConfigDTO;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModConfigDTO.class)
public class FreecamModConfigDTOMixin {

	@Inject(method = "ignoreCollisionWith", at = @At("HEAD"), remap = false, cancellable = true)
	private static void isIgnored(Block block, CallbackInfoReturnable<Boolean> cir) {
		if (FreecamIntegration.forceCollision) {
			cir.setReturnValue(false);
		}
	}
}
