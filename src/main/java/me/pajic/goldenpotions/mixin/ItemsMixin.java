package me.pajic.goldenpotions.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.pajic.goldenpotions.GoldenPotions;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Items.class)
public class ItemsMixin {

	@WrapOperation(
			method = "<clinit>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;food(Lnet/minecraft/world/food/FoodProperties;)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private static Item.Properties goldenItemsNotEdible(Item.Properties instance, FoodProperties foodProperties, Operation<Item.Properties> original) {
		return foodProperties.equals(Foods.GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleGoldenApple.get() ||
				foodProperties.equals(Foods.ENCHANTED_GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleEnchantedGoldenApple.get() ||
				foodProperties.equals(Foods.GOLDEN_CARROT) && !GoldenPotions.CONFIG.edibleGoldenCarrot.get() ?
				instance : original.call(instance, foodProperties);
	}

	@WrapOperation(
			method = "<clinit>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;food(Lnet/minecraft/world/food/FoodProperties;Lnet/minecraft/world/item/component/Consumable;)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private static Item.Properties goldenItemsNotEdible(Item.Properties instance, FoodProperties foodProperties, Consumable consumable, Operation<Item.Properties> original) {
		return consumable.equals(Consumables.GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleGoldenApple.get() ||
				consumable.equals(Consumables.ENCHANTED_GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleEnchantedGoldenApple.get() ?
				instance : original.call(instance, foodProperties, consumable);
	}
}
