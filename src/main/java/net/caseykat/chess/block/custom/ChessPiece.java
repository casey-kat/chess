package net.caseykat.chess.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class ChessPiece extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
	protected static final VoxelShape BASE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	protected static final VoxelShape BASE_COLLIDE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	
	public DyeColor color;
	
	public ChessPiece(DyeColor color) {
		super(BlockBehaviour.Properties
				.of()
				.noOcclusion()
				.strength(0.2F, 5)
				.mapColor(color)
				.sound(SoundType.SCAFFOLDING)
		);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
		this.color = color;
	}
	
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pState) {
		pState.add(FACING).add(WATERLOGGED);
	}
	
	public VoxelShape getShape(BlockState pState, BlockGetter pGetter, BlockPos pPos, CollisionContext pCollision) {
		return BASE;
	}
	
	public VoxelShape getCollisionShape(BlockState pState, BlockGetter pGetter, BlockPos pPos, CollisionContext pCollision) {
		return BASE_COLLIDE;
	}

	public boolean isPathfindable(BlockState pState, BlockGetter pGetter, BlockPos pPos, PathComputationType pPath) {
		return false;
	}
}
