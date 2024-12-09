package net.caseykat.chess.block;

import net.caseykat.chess.Chess;
import net.caseykat.chess.block.custom.ChessPiece;
import net.caseykat.chess.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.function.Supplier;

import static net.minecraft.world.item.DyeColor.*;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Chess.MODID);
	
	//	public static String[] COLOR =  {"white", "black", "blue", "green", "purple", "red", "yellow"};
	public static String[] COLOR =  {
			"black",
			"white",
			"lightgrey",
			"grey",
			"pink",
			"magenta",
			"purple",
			"blue",
			"lightblue",
			"cyan",
			"green",
			"lime",
			"yellow",
			"orange",
			"red",
			"brown",
	};
	
	public static String[] TYPE = {
			"pawn",
			"knight",
			"bishop",
			"rook",
			"king",
			"queen"
	};
	
	public static ArrayList<RegistryObject<ChessPiece>> PIECES = populateList();
	private static ArrayList<RegistryObject<ChessPiece>> populateList() {
		ArrayList<RegistryObject<ChessPiece>> list = new ArrayList<>();
		for(String color : ModBlocks.COLOR) {
			for(String type : ModBlocks.TYPE) {
				RegistryObject<ChessPiece> block = registerBlock(color + "_" + type + "_block", () -> new ChessPiece(DyeColor.WHITE));
				list.add(block);
			}
		}
		return list;
	}
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> result = BLOCKS.register(name, block);
		registerBlockItem(name, result);
		return result;
	}
	
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
