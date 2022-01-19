package com.waffleer.snakecraft.block.custom;

import com.waffleer.snakecraft.block.ModBlocks;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class PointySticks extends Block {
    public static final BooleanProperty STATUS = BooleanProperty.create("status");
    public static final DamageSource POINTYSTICKS = new DamageSource("pointy_sticks");


    public PointySticks(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.defaultBlockState().setValue(STATUS, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(STATUS);
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()){
            if(pHand == InteractionHand.MAIN_HAND) {
                interactionClick(pState, pLevel, pPos, pPlayer, pHand, pHit);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pLevel.isClientSide()){
            if(pEntity instanceof LivingEntity && pState.getValue(STATUS)) {
                LivingEntity entity = ((LivingEntity) pEntity);
                entity.hurt(POINTYSTICKS,2f);
            }

        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

    public void interactionClick(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit){
        boolean current = pState.getValue(STATUS);
        interaction(pLevel, pPos, !current);
        if(!current){
            pPlayer.sendMessage(new TextComponent("The Spikes Extend"), Util.NIL_UUID);
        }
        else{
            pPlayer.sendMessage(new TextComponent("The Spikes Disappear"), Util.NIL_UUID);
        }
    }

    public void interaction(Level pLevel, BlockPos pPos, boolean value) {
        Block block = pLevel.getBlockState(pPos).getBlock();
        if(block == ModBlocks.POINTYSTICKS.get()){
            BlockState pState = pLevel.getBlockState(pPos);
            boolean current = pState.getValue(STATUS);
            if (current != value) {
                pLevel.setBlock(pPos, pState.setValue(STATUS, value), 3);
                BlockPos x1 = new BlockPos(pPos.getX() + 1, pPos.getY(), pPos.getZ());
                BlockPos xn = new BlockPos(pPos.getX() - 1, pPos.getY(), pPos.getZ());
                BlockPos z1 = new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() + 1);
                BlockPos zn = new BlockPos(pPos.getX(), pPos.getY(), pPos.getZ() - 1);
                interaction(pLevel, x1, value);
                interaction(pLevel, xn, value);
                interaction(pLevel, z1, value);
                interaction(pLevel, zn, value);
            }
        }
    }
}
