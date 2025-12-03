package me.pajic.goldenpotions.platform.fabric;

//? fabric {

import me.pajic.goldenpotions.mixson.ClientResourceModifications;
import net.fabricmc.api.ClientModInitializer;

@SuppressWarnings("unused")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ClientResourceModifications.init();
	}
}
//?}
