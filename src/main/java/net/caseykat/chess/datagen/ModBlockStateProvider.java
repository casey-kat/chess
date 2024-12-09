package net.caseykat.chess.datagen;

import net.caseykat.chess.Chess;
import net.caseykat.chess.block.ModBlocks;
import net.caseykat.chess.block.custom.ChessPiece;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModBlockStateProvider extends BlockStateProvider {
	public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, Chess.MODID, exFileHelper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		int i = 0;
		for(String c : ModBlocks.COLOR) {
			for(String t : ModBlocks.TYPE) {
				String id = c + "_" + t;
				horizontalBlock(ModBlocks.PIECES.get(i).get(), new ModelFile.UncheckedModelFile(modLoc(String.format("block/%s_block", id))));
				i++;
			}
		}
	}
	
	private String name(Block block) {
		return key(block).getPath();
	}
	
	private ResourceLocation key(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block);
	}
	
	private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
	}
	
	private void blockItem(RegistryObject<Block> blockRegistryObject) {
		simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Chess.MODID +
				":block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
	}
	
	private void horizontalBlockItem(RegistryObject<Block> blockRegistryObject) {
		horizontalBlock(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(Chess.MODID +
				":block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
	}
}
