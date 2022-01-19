package com.waffleer.snakecraft.block;

import com.waffleer.snakecraft.SnakeCraft;
import com.waffleer.snakecraft.block.custom.PointySticks;
import com.waffleer.snakecraft.block.custom.PoisonSticks;
import com.waffleer.snakecraft.item.ModCreativeModeTab;
import com.waffleer.snakecraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SnakeCraft.MOD_ID);


    public static final RegistryObject<Block> SCALE_BLOCK = registerBlock
            ("scale_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WILTED_LOG = registerBlock
            ("wilted_log", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1f)));

    public static final RegistryObject<Block> POISONSTICKS = registerBlock
            ("poison_sticks", () -> new PoisonSticks(BlockBehaviour.Properties.of(Material.WOOD).strength(1f)));

    public static final RegistryObject<Block> POINTYSTICKS = registerBlock
            ("pointy_sticks", () -> new PointySticks(BlockBehaviour.Properties.of(Material.WOOD).strength(1f)));



    private  static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private  static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.SNAKECRAFT_TAB))
        );
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register((eventBus));
    }
}
