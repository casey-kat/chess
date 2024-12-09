package net.caseykat.chess.item;

import net.caseykat.chess.Chess;
import net.caseykat.chess.block.custom.ChessPiece;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.DyeColor.BLACK;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Chess.MODID);
	
	public static final RegistryObject<Item> CHESS_SET = ITEMS.register("chess_set", () -> new Item(new Item.Properties()));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
