package com.waffleer.snakecraft.item.custom;


import com.google.common.collect.ImmutableMap;
import com.waffleer.snakecraft.block.ModBlocks;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class SmartSnakeSwordItem extends Item {

    private static final Map<Block, Block> SNAKE_SWORD_CONVERT =
            new ImmutableMap.Builder<Block, Block>()
                    .put(Blocks.ACACIA_LOG, ModBlocks.WILTED_LOG.get())
                    .put(Blocks.BIRCH_LOG, ModBlocks.WILTED_LOG.get())
                    .put(Blocks.DARK_OAK_LOG, ModBlocks.WILTED_LOG.get())
                    .put(Blocks.JUNGLE_LOG, ModBlocks.WILTED_LOG.get())
                    .put(Blocks.OAK_LOG, ModBlocks.WILTED_LOG.get())
                    .put(Blocks.SPRUCE_LOG, ModBlocks.WILTED_LOG.get())
                    .build();



    public SmartSnakeSwordItem(Properties pProperties) {
        super(pProperties);
    }




    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            //If server
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if(canConvert(blockClicked)) {
                level.setBlockAndUpdate(positionClicked, SNAKE_SWORD_CONVERT.get(blockClicked).defaultBlockState());


                /*
                This will cause wood to break wilted wood
                ItemEntity entityItem = new ItemEntity(level, positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(SNAKE_SWORD_CONVERT.get(blockClicked), 1));
                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                    p.broadcastBreakEvent(pContext.getHand());
                });
                */
            }
            /*
            else {
                pContext.getPlayer().sendMessage(new TextComponent("That's not wood"), Util.NIL_UUID);
            }
            */
        }

        return InteractionResult.SUCCESS;
    }



    private boolean canConvert(Block block) {
        return SNAKE_SWORD_CONVERT.containsKey(block);
    }
}




















