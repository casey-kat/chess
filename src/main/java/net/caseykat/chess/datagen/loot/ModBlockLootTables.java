package net.caseykat.chess.datagen.loot;

import net.caseykat.chess.Chess;
import net.caseykat.chess.block.ModBlocks;
import net.caseykat.chess.block.custom.ChessPiece;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
	public ModBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate() {
		for(RegistryObject<ChessPiece> block : ModBlocks.PIECES) {
			this.dropSelf(block.get());
		}
	}
	
	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
}
