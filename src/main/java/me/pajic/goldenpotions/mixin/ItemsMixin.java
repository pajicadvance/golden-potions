package me.pajic.goldenpotions.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.pajic.goldenpotions.GoldenPotions;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
//? if > 1.21.1 {
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
//?}

@Mixin(Items.class)
public class ItemsMixin {

	@WrapOperation(
			method = "<clinit>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;food(Lnet/minecraft/world/food/FoodProperties;)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private static Item.Properties goldenItemsNotEdible(Item.Properties instance, FoodProperties food, Operation<Item.Properties> original) {
		return food.equals(Foods.GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleGoldenApple.get() ||
				food.equals(Foods.ENCHANTED_GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleEnchantedGoldenApple.get() ||
				food.equals(Foods.GOLDEN_CARROT) && !GoldenPotions.CONFIG.edibleGoldenCarrot.get() ?
				instance : original.call(instance, food);
	}

	//? if > 1.21.1 {
	@WrapOperation(
			method = "<clinit>",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/Item$Properties;food(Lnet/minecraft/world/food/FoodProperties;Lnet/minecraft/world/item/component/Consumable;)Lnet/minecraft/world/item/Item$Properties;"
			)
	)
	private static Item.Properties goldenItemsNotEdible(Item.Properties instance, FoodProperties food, Consumable consumable, Operation<Item.Properties> original) {
		return consumable.equals(Consumables.GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleGoldenApple.get() ||
				consumable.equals(Consumables.ENCHANTED_GOLDEN_APPLE) && !GoldenPotions.CONFIG.edibleEnchantedGoldenApple.get() ?
				instance : original.call(instance, food, consumable);
	}
	//?}
}
