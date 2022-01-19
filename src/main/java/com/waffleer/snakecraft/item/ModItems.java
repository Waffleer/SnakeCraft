package com.waffleer.snakecraft.item;

import com.waffleer.snakecraft.item.custom.SmartSnakeSwordItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import com.waffleer.snakecraft.SnakeCraft;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SnakeCraft.MOD_ID);
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }




    public static final RegistryObject<Item> SNAKE_SWORD = ITEMS.register( "snake_sword",
            () -> new SmartSnakeSwordItem(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB).durability(100))             );

    // Snake Metals
    public static final RegistryObject<Item> SNAKE_INGOT = ITEMS.register( "snake_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );


    // Snake Ingredients
    public static final RegistryObject<Item> SNAKE_SCALE = ITEMS.register( "snake_scale",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );

    public static final RegistryObject<Item> SNAKE_DUST = ITEMS.register( "scale_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );

    public static final RegistryObject<Item> SNAKE_SKIN_STRING = ITEMS.register( "snake_skin_string",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );


    // Basic Ingredients
    public static final RegistryObject<Item> POINTY_STICK = ITEMS.register( "pointy_stick",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );

    public static final RegistryObject<Item> BUNDLE_OF_POINTY_STICKS = ITEMS.register( "bundle_of_pointy_sticks",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );

    // Flower Ingredients
    public static final RegistryObject<Item> NERIUM_OLEANDER_HEAD = ITEMS.register( "nerium_oleander_head",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );

    public static final RegistryObject<Item> NERIUM_OLEANDER_SEED = ITEMS.register( "nerium_oleander_seed",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))             );










}
