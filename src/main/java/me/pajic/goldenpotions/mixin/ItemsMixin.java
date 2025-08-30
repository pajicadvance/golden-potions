package me.pajic.goldenpotions.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.pajic.goldenpotions.Main;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
    private static Item.Properties goldenItemsNotEdible(Item.Properties instance, FoodProperties food, Operation<Item.Properties> original) {
        return food.equals(Foods.GOLDEN_APPLE) && !Main.CONFIG.edibleGoldenApple.get() ||
                food.equals(Foods.ENCHANTED_GOLDEN_APPLE) && !Main.CONFIG.edibleEnchantedGoldenApple.get() ||
                food.equals(Foods.GOLDEN_CARROT) && !Main.CONFIG.edibleGoldenCarrot.get() ?
                instance : original.call(instance, food);
    }
}
