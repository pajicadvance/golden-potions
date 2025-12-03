package me.pajic.goldenpotions;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.pajic.goldenpotions.config.ModConfig;
import me.pajic.goldenpotions.platform.Platform;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//? fabric {
import me.pajic.goldenpotions.platform.fabric.FabricPlatform;
//?} neoforge {
/*import me.pajic.goldenpotions.platform.neoforge.NeoforgePlatform;
*///?}

@SuppressWarnings("LoggingSimilarMessage")
public class GoldenPotions {

	public static final String MOD_ID = /*$ mod_id*/ "goldenpotions";
	public static final String MOD_VERSION = /*$ mod_version*/ "1.0.3";
	public static final String MOD_FRIENDLY_NAME = /*$ mod_name*/ "Golden Potions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ResourceLocation CONFIG_RL = id("config");
	public static ModConfig CONFIG = ConfigApiJava.registerAndLoadConfig(ModConfig::new);
	private static final Platform PLATFORM = createPlatformInstance();

	public static Platform xplat() {
		return PLATFORM;
	}

	private static Platform createPlatformInstance() {
		//? fabric {
		return new FabricPlatform();
		//?} neoforge {
		/*return new NeoforgePlatform();
		*///?}
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	public static void debugLog(String message, Object ... args) {
		if (PLATFORM.isDebug()) LOGGER.info(message, args);
	}
}
