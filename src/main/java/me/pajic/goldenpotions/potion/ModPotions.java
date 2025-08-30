package me.pajic.goldenpotions.potion;

import me.pajic.goldenpotions.Main;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;

public class ModPotions {
    public static final Potion ABSORPTION = Registry.register(
            BuiltInRegistries.POTION,
            Main.withModNamespace("absorption"),
            new Potion(
                    "absorption",
                    new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0)
            )
    );
    public static final Potion LONG_ABSORPTION = Registry.register(
            BuiltInRegistries.POTION,
            Main.withModNamespace("long_absorption"),
            new Potion(
                    "absorption",
                    new MobEffectInstance(MobEffects.ABSORPTION, 4800, 0)
            )
    );
    public static final Potion STRONG_ABSORPTION = Registry.register(
            BuiltInRegistries.POTION,
            Main.withModNamespace("strong_absorption"),
            new Potion(
                    "absorption",
                    new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1)
            )
    );
    public static final Potion LIFE_ELIXIR = Registry.register(
            BuiltInRegistries.POTION,
            Main.withModNamespace("elixir_of_life"),
            new Potion(
                    "elixir_of_life",
                    new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3),
                    new MobEffectInstance(MobEffects.REGENERATION, 400, 1),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0),
                    new MobEffectInstance(
                            MobEffects./*? if < 1.21.8 {*/DAMAGE_RESISTANCE/*?}*//*? if >= 1.21.8 {*//*RESISTANCE*//*?}*/,
                            6000, 0
                    )
            )
    );

    public static boolean isElixirOfLife(ItemStack stack) {
        PotionContents potionContents = stack.get(DataComponents.POTION_CONTENTS);
        return potionContents != null && potionContents.potion().orElse(Potions.WATER).is(
                Main.withModNamespace("elixir_of_life")
        );
    }

    public static ChatFormatting getElixirOfLifeNameColor() {
        //? if < 1.21.8
        return ChatFormatting.LIGHT_PURPLE;
        //? if >= 1.21.8
        /*return ChatFormatting.AQUA;*/
    }

    public static void init() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    Ingredient.of(Items.GOLDEN_APPLE),
                    BuiltInRegistries.POTION.wrapAsHolder(ABSORPTION)
            );
            builder.registerPotionRecipe(
                    BuiltInRegistries.POTION.wrapAsHolder(ABSORPTION),
                    Ingredient.of(Items.REDSTONE),
                    BuiltInRegistries.POTION.wrapAsHolder(LONG_ABSORPTION)
            );
            builder.registerPotionRecipe(
                    BuiltInRegistries.POTION.wrapAsHolder(ABSORPTION),
                    Ingredient.of(Items.GLOWSTONE_DUST),
                    BuiltInRegistries.POTION.wrapAsHolder(STRONG_ABSORPTION)
            );
            builder.registerPotionRecipe(
                    Potions.AWKWARD,
                    Ingredient.of(Items.ENCHANTED_GOLDEN_APPLE),
                    BuiltInRegistries.POTION.wrapAsHolder(LIFE_ELIXIR)
            );
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries ->
                entries.addAfter(Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE)
        );
    }
}
