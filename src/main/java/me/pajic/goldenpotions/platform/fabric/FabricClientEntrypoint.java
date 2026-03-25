package me.pajic.goldenpotions.platform.fabric;

//? fabric {

import me.pajic.goldenpotions.GoldenPotions;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		GoldenPotions.onInitializeClient();
	}
}
//?}
