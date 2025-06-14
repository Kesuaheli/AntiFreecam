package de.kesuaheli.antifreecam.client.mixin;

import de.kesuaheli.antifreecam.client.integration.FreecamIntegration;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
	@Override
	public void onLoad(String mixinPackage) {
		FreecamIntegration.fetchFreecam();
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		if (mixinClassName.equals("CollisionBehavior")) {
			return FreecamIntegration.isFreecamPresent();
		}
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
	}

	@Override
	public List<String> getMixins() {
		var mixins = new ArrayList<String>();

		if (FreecamIntegration.isFreecamPresent()) {
			mixins.add("CollisionBehaviorMixin");
		}

		// Return null to use mixins.json instead
		return mixins;
	}

	@Override
	public void preApply(String targetClassName, ClassNode classNode, String mixinClassName, IMixinInfo iMixinInfo) {;
	}

	@Override
	public void postApply(String targetClassName, ClassNode classNode, String mixinClassName, IMixinInfo iMixinInfo) {
	}
}
