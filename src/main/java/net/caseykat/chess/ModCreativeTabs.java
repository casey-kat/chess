package net.caseykat.chess;

import net.caseykat.chess.block.ModBlocks;
import net.caseykat.chess.block.custom.ChessPiece;
import net.caseykat.chess.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Chess.MODID);
	
	public static final RegistryObject<CreativeModeTab> CHESS_TAB = CREATIVE_MODE_TABS.register("chess_tab",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PIECES.get(0).get()))
					.title(Component.translatable("creativetab.chess_tab"))
					.displayItems((pParameters, pOutput) -> {
						pOutput.accept(ModItems.CHESS_SET.get());
						
						for(RegistryObject<ChessPiece> block : ModBlocks.PIECES) {
							pOutput.accept(block.get());
						}
					})
					.build());
	
	public static void register(IEventBus eventBus) { CREATIVE_MODE_TABS.register(eventBus); }
}
