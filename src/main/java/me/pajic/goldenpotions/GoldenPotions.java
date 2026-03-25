package me.pajic.goldenpotions;

import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.pajic.goldenpotions.config.ModConfig;
import me.pajic.goldenpotions.mixson.AssetPatches;
import me.pajic.goldenpotions.platform.Platform;
import net.minecraft.resources.Identifier;
import net.ramixin.mixson.Mixson;
import net.ramixin.mixson.enums.DebugOption;
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
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final Platform PLATFORM = createPlatformInstance();
	public static ModConfig CONFIG = ConfigApiJava.registerAndLoadConfig(ModConfig::new);

	public static void onInitialize() {
		if (PLATFORM.isDebug()) {
			Mixson.enableDebugOption(DebugOption.BASIC_LOGGING);
			Mixson.enableDebugOption(DebugOption.EXTRA_LOGGING);
			Mixson.enableDebugOption(DebugOption.EXPORT_PATCHED_FILE);
		}
	}

	public static void onInitializeClient() {
		AssetPatches.init();
	}

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

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	public static void debugLog(String message, Object ... args) {
		if (PLATFORM.isDebug()) LOGGER.info(message, args);
	}
}
