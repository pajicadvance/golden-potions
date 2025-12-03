package me.pajic.goldenpotions.potion;

import me.pajic.goldenpotions.GoldenPotions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;

public class ModPotions {

	public static final Potion ABSORPTION = new Potion(
			"absorption",
			new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0)
	);
	public static final Potion LONG_ABSORPTION = new Potion(
			"absorption",
			new MobEffectInstance(MobEffects.ABSORPTION, 4800, 0)
	);
	public static final Potion STRONG_ABSORPTION = new Potion(
			"absorption",
			new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1)
	);
	public static final Potion LIFE_ELIXIR = new Potion(
			"elixir_of_life",
			new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3),
			new MobEffectInstance(MobEffects.REGENERATION, 400, 1),
			new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0),
			new MobEffectInstance(
					MobEffects./*? if 1.21.1 {*//*DAMAGE_RESISTANCE*//*?} else {*/RESISTANCE/*?}*/,
					6000, 0
			)
	);

	public static boolean isElixirOfLife(ItemStack stack) {
		PotionContents potionContents = stack.get(DataComponents.POTION_CONTENTS);
		return potionContents != null && potionContents.potion().orElse(Potions.WATER).is(
				GoldenPotions.id("elixir_of_life")
		);
	}

	public static ChatFormatting getElixirOfLifeNameColor() {
		//? if 1.21.1
		//return ChatFormatting.LIGHT_PURPLE;
		//? if > 1.21.1
		return ChatFormatting.AQUA;
	}

	public static void init() {}
}
