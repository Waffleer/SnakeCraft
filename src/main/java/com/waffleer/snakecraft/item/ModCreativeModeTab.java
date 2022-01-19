package com.waffleer.snakecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.system.CallbackI;

public class ModCreativeModeTab {

    public static final CreativeModeTab SNAKECRAFT_TAB = new CreativeModeTab("snakecraft_tab") {
        @Override
        public ItemStack makeIcon() {
            //This is what item displays as ico
            return new ItemStack(ModItems.SNAKE_INGOT.get());
        }
    };
}
