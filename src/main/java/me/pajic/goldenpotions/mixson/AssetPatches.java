package me.pajic.goldenpotions.mixson;

import me.pajic.goldenpotions.GoldenPotions;
import net.minecraft.client.Minecraft;

public class AssetPatches {

	public static void init() {
		if (GoldenPotions.xplat().isModLoaded("item-descriptions")) MixsonHelper.registerMultiJson(
				"Apply item description overrides",
				index -> index.id().toString().startsWith("item_descriptions:lang/"),
				context -> {
					if (context.getIndex().id().getPath().contains(Minecraft.getInstance().getLanguageManager().getSelected())) {
						try {
							if (!GoldenPotions.CONFIG.edibleGoldenApple.get()) {
								context.getFile().getAsJsonObject().remove("lore.minecraft.golden_apple");
							}
							if (!GoldenPotions.CONFIG.edibleEnchantedGoldenApple.get()) {
								context.getFile().getAsJsonObject().remove("lore.minecraft.enchanted_golden_apple");
							}
							if (!GoldenPotions.CONFIG.edibleGoldenCarrot.get()) {
								context.getFile().getAsJsonObject().remove("lore.minecraft.golden_carrot");
							}
						} catch (NullPointerException ignored) {}
					}
				}
		);
	}
}
