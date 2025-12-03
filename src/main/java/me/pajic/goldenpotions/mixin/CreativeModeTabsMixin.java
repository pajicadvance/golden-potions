package me.pajic.goldenpotions.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import me.pajic.goldenpotions.GoldenPotions;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CreativeModeTabs.class)
public class CreativeModeTabsMixin {

	@Definition(id = "accept", method = "Lnet/minecraft/world/item/CreativeModeTab$Output;accept(Lnet/minecraft/world/level/ItemLike;)V")
	@Definition(id = "GOLDEN_APPLE", field = "Lnet/minecraft/world/item/Items;GOLDEN_APPLE:Lnet/minecraft/world/item/Item;")
	@Expression("?.accept(GOLDEN_APPLE)")
	@WrapWithCondition(
			method = /*? fabric {*/"method_51323"/*?} else {*//*"lambda$bootstrap$23"*//*?}*/,
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static boolean removeGoldenAppleFromFoodAndDrinksCategory(CreativeModeTab.Output instance, ItemLike item) {
		return GoldenPotions.CONFIG.edibleGoldenApple.get();
	}

	@Definition(id = "accept", method = "Lnet/minecraft/world/item/CreativeModeTab$Output;accept(Lnet/minecraft/world/level/ItemLike;)V")
	@Definition(id = "ENCHANTED_GOLDEN_APPLE", field = "Lnet/minecraft/world/item/Items;ENCHANTED_GOLDEN_APPLE:Lnet/minecraft/world/item/Item;")
	@Expression("?.accept(ENCHANTED_GOLDEN_APPLE)")
	@WrapWithCondition(
			method = /*? fabric {*/"method_51323"/*?} else {*//*"lambda$bootstrap$23"*//*?}*/,
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static boolean removeEnchantedGoldenAppleFromFoodAndDrinksCategory(CreativeModeTab.Output instance, ItemLike item) {
		return GoldenPotions.CONFIG.edibleEnchantedGoldenApple.get();
	}

	@Definition(id = "accept", method = "Lnet/minecraft/world/item/CreativeModeTab$Output;accept(Lnet/minecraft/world/level/ItemLike;)V")
	@Definition(id = "GOLDEN_CARROT", field = "Lnet/minecraft/world/item/Items;GOLDEN_CARROT:Lnet/minecraft/world/item/Item;")
	@Expression("?.accept(GOLDEN_CARROT)")
	@WrapWithCondition(
			method = /*? fabric {*/"method_51323"/*?} else {*//*"lambda$bootstrap$23"*//*?}*/,
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private static boolean removeGoldenCarrotFromFoodAndDrinksCategory(CreativeModeTab.Output instance, ItemLike item) {
		return GoldenPotions.CONFIG.edibleGoldenCarrot.get();
	}

	@ModifyExpressionValue(
			method = /*? fabric {*/"method_51337"/*?} else {*//*"lambda$bootstrap$21"*//*?}*/,
			at = @At(
					value = "FIELD",
					target = "Lnet/minecraft/world/item/Items;GOLDEN_APPLE:Lnet/minecraft/world/item/Item;",
					opcode = Opcodes.GETSTATIC
			)
	)
	private static Item changeFoodAndDrinksCategoryIcon(Item original) {
		return GoldenPotions.CONFIG.edibleGoldenApple.get() ? original : Items.APPLE;
	}
}
