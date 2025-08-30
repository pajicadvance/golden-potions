package me.pajic.goldenpotions.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import me.pajic.goldenpotions.potion.ModPotions;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TippedArrowItem;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TippedArrowItem.class)
public abstract class TippedArrowItemMixin extends Item {
    public TippedArrowItemMixin(Properties properties) {
        super(properties);
    }

    //? if < 1.21.8 {
    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        return ModPotions.isElixirOfLife(stack) ?
                super.getName(stack).copy().withStyle(ModPotions.getElixirOfLifeNameColor()) :
                super.getName(stack);
    }
    //?}
    //? if >= 1.21.8 {
    /*@ModifyReturnValue(
            method = "getName",
            at = @At("RETURN")
    )
    private Component modifyName(Component original, @Local(argsOnly = true) ItemStack stack) {
        return ModPotions.isElixirOfLife(stack) ?
                original.copy().withStyle(ModPotions.getElixirOfLifeNameColor()) :
                original;
    }
    *///?}

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return ModPotions.isElixirOfLife(stack) || super.isFoil(stack);
    }
}
