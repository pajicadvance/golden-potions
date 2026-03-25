package me.pajic.goldenpotions.platform.neoforge;

//? neoforge {

/*import me.pajic.goldenpotions.GoldenPotions;
import me.pajic.goldenpotions.potion.ModPotions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(GoldenPotions.MOD_ID)
@EventBusSubscriber(modid = GoldenPotions.MOD_ID)
public class NeoforgeEntrypoint {

	@SubscribeEvent
	private static void onCommonSetup(FMLCommonSetupEvent event) {
		GoldenPotions.onInitialize();
	}

	@SubscribeEvent
	private static void initRegistry(RegisterEvent event) {
		ModPotions.init();
		event.register(
				Registries.POTION,
				registry -> {
					registry.register(GoldenPotions.id("absorption"), ModPotions.ABSORPTION);
					registry.register(GoldenPotions.id("long_absorption"), ModPotions.LONG_ABSORPTION);
					registry.register(GoldenPotions.id("strong_absorption"), ModPotions.STRONG_ABSORPTION);
					registry.register(GoldenPotions.id("elixir_of_life"), ModPotions.LIFE_ELIXIR);
				}
		);
	}

	@SubscribeEvent
	private static void initBrewing(RegisterBrewingRecipesEvent event) {
		event.getBuilder().addMix(
				Potions.AWKWARD,
				Items.GOLDEN_APPLE,
				BuiltInRegistries.POTION.wrapAsHolder(ModPotions.ABSORPTION)
		);
		event.getBuilder().addMix(
				BuiltInRegistries.POTION.wrapAsHolder(ModPotions.ABSORPTION),
				Items.REDSTONE,
				BuiltInRegistries.POTION.wrapAsHolder(ModPotions.LONG_ABSORPTION)
		);
		event.getBuilder().addMix(
				BuiltInRegistries.POTION.wrapAsHolder(ModPotions.ABSORPTION),
				Items.GLOWSTONE_DUST,
				BuiltInRegistries.POTION.wrapAsHolder(ModPotions.STRONG_ABSORPTION)
		);
		event.getBuilder().addMix(
				Potions.AWKWARD,
				Items.ENCHANTED_GOLDEN_APPLE,
				BuiltInRegistries.POTION.wrapAsHolder(ModPotions.LIFE_ELIXIR)
		);
	}

	@SubscribeEvent
	private static void initCreativeTabs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.insertAfter(
					Items.GOLDEN_CARROT.getDefaultInstance(),
					Items.GOLDEN_APPLE.getDefaultInstance(),
					CreativeModeTab.TabVisibility.PARENT_TAB_ONLY
			);
			event.insertAfter(
					Items.GOLDEN_APPLE.getDefaultInstance(),
					Items.ENCHANTED_GOLDEN_APPLE.getDefaultInstance(),
					CreativeModeTab.TabVisibility.PARENT_TAB_ONLY
			);
		}
	}
}
*///?}
