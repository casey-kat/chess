package net.caseykat.chess;

import net.caseykat.chess.block.ModBlocks;
import net.caseykat.chess.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Chess.MODID)
public class Chess {

    public static final String MODID = "chess";

    public Chess() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
}
