package me.pajic.goldenpotions.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import me.pajic.goldenpotions.Main;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CreativeModeTabs.class)
public class CreativeModeTabsMixin {

    @Definition(id = "accept", method = "Lnet/minecraft/world/item/CreativeModeTab$Output;accept(Lnet/minecraft/world/level/ItemLike;)V")
    @Definition(id = "GOLDEN_APPLE", field = "Lnet/minecraft/world/item/Items;GOLDEN_APPLE:Lnet/minecraft/world/item/Item;")
    @Expression("?.accept(GOLDEN_APPLE)")
    @WrapWithCondition(
            method = "method_51323",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static boolean removeGoldenAppleFromFoodAndDrinksCategory(CreativeModeTab.Output instance, ItemLike item) {
        return Main.CONFIG.edibleGoldenApple.get();
    }

    @Definition(id = "accept", method = "Lnet/minecraft/world/item/CreativeModeTab$Output;accept(Lnet/minecraft/world/level/ItemLike;)V")
    @Definition(id = "ENCHANTED_GOLDEN_APPLE", field = "Lnet/minecraft/world/item/Items;ENCHANTED_GOLDEN_APPLE:Lnet/minecraft/world/item/Item;")
    @Expression("?.accept(ENCHANTED_GOLDEN_APPLE)")
    @WrapWithCondition(
            method = "method_51323",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static boolean removeEnchantedGoldenAppleFromFoodAndDrinksCategory(CreativeModeTab.Output instance, ItemLike item) {
        return Main.CONFIG.edibleEnchantedGoldenApple.get();
    }

    @Definition(id = "accept", method = "Lnet/minecraft/world/item/CreativeModeTab$Output;accept(Lnet/minecraft/world/level/ItemLike;)V")
    @Definition(id = "GOLDEN_CARROT", field = "Lnet/minecraft/world/item/Items;GOLDEN_CARROT:Lnet/minecraft/world/item/Item;")
    @Expression("?.accept(GOLDEN_CARROT)")
    @WrapWithCondition(
            method = "method_51323",
            at = @At("MIXINEXTRAS:EXPRESSION")
    )
    private static boolean removeGoldenCarrotFromFoodAndDrinksCategory(CreativeModeTab.Output instance, ItemLike item) {
        return Main.CONFIG.edibleGoldenCarrot.get();
    }

    @ModifyExpressionValue(
            method = "method_51337",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/item/Items;GOLDEN_APPLE:Lnet/minecraft/world/item/Item;"
            )
    )
    private static Item changeFoodAndDrinksCategoryIcon(Item original) {
        return Main.CONFIG.edibleGoldenApple.get() ? original : Items.APPLE;
    }
}
