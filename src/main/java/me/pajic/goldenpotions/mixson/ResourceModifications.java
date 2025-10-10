package me.pajic.goldenpotions.mixson;

import me.pajic.goldenpotions.Main;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.ramixin.mixson.inline.Mixson;

public class ResourceModifications {

    public static void init() {
        if (FabricLoader.getInstance().isModLoaded("item-descriptions")) Mixson.registerEvent(
                Mixson.DEFAULT_PRIORITY,
                rl -> rl.toString().startsWith("item_descriptions:lang/"),
                "Apply item description overrides",
                context -> {
                    if (context.getResourceId().getPath().contains(Minecraft.getInstance().getLanguageManager().getSelected())) {
                        try {
                            if (!Main.CONFIG.edibleGoldenApple.get()) {
                                context.getFile().getAsJsonObject().remove("lore.minecraft.golden_apple");
                            }
                            if (!Main.CONFIG.edibleEnchantedGoldenApple.get()) {
                                context.getFile().getAsJsonObject().remove("lore.minecraft.enchanted_golden_apple");
                            }
                            if (!Main.CONFIG.edibleGoldenCarrot.get()) {
                                context.getFile().getAsJsonObject().remove("lore.minecraft.golden_carrot");
                            }
                        } catch (NullPointerException ignored) {}
                    }
                },
                true
        );
    }
}
