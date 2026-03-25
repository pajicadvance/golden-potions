package me.pajic.goldenpotions.platform.fabric;

//? fabric {

import me.pajic.goldenpotions.GoldenPotions;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import me.pajic.goldenpotions.potion.ModPotions;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

@Entrypoint("main")
public class FabricEntrypoint implements ModInitializer {

	@Override
	public void onInitialize() {
		GoldenPotions.onInitialize();
		initRegistry();
		initBrewing();
		initCreativeTabs();
	}

	private static void initRegistry() {
		ModPotions.init();
		Registry.register(
				BuiltInRegistries.POTION,
				GoldenPotions.id("absorption"),
				ModPotions.ABSORPTION
		);
		Registry.register(
				BuiltInRegistries.POTION,
				GoldenPotions.id("long_absorption"),
				ModPotions.LONG_ABSORPTION
		);
		Registry.register(
				BuiltInRegistries.POTION,
				GoldenPotions.id("strong_absorption"),
				ModPotions.STRONG_ABSORPTION
		);
		Registry.register(
				BuiltInRegistries.POTION,
				GoldenPotions.id("elixir_of_life"),
				ModPotions.LIFE_ELIXIR
		);
	}

	private static void initBrewing() {
		FabricPotionBrewingBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(
					Potions.AWKWARD,
					Ingredient.of(Items.GOLDEN_APPLE),
					BuiltInRegistries.POTION.wrapAsHolder(ModPotions.ABSORPTION)
			);
			builder.registerPotionRecipe(
					BuiltInRegistries.POTION.wrapAsHolder(ModPotions.ABSORPTION),
					Ingredient.of(Items.REDSTONE),
					BuiltInRegistries.POTION.wrapAsHolder(ModPotions.LONG_ABSORPTION)
			);
			builder.registerPotionRecipe(
					BuiltInRegistries.POTION.wrapAsHolder(ModPotions.ABSORPTION),
					Ingredient.of(Items.GLOWSTONE_DUST),
					BuiltInRegistries.POTION.wrapAsHolder(ModPotions.STRONG_ABSORPTION)
			);
			builder.registerPotionRecipe(
					Potions.AWKWARD,
					Ingredient.of(Items.ENCHANTED_GOLDEN_APPLE),
					BuiltInRegistries.POTION.wrapAsHolder(ModPotions.LIFE_ELIXIR)
			);
		});
	}

	private static void initCreativeTabs() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(entries ->
				entries.insertAfter(Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE)
		);
	}
}
//?}
