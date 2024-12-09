package net.caseykat.chess.datagen;

import net.caseykat.chess.Chess;
import net.caseykat.chess.block.ModBlocks;
import net.caseykat.chess.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Chess.MODID, existingFileHelper);
	}
	@Override
	protected void registerModels() {
		handheldItem(ModItems.CHESS_SET);
		
		for (String c : ModBlocks.COLOR) {
			for (String t : ModBlocks.TYPE) {
				String id = c + "_" + t;
				this.withExistingParent(String.format("%s:block/%s_block", Chess.MODID, id), modLoc(String.format("block/%s_block", t)))
						.texture("0", modLoc(String.format("block/%s_chess", c)))
						.texture("texture", modLoc(String.format("block/%s_chess", c)))
						.texture("particle", modLoc(String.format("block/%s_chess", c)));
				this.withExistingParent(String.format("%s:item/%s_block", Chess.MODID, id), modLoc(String.format("block/%s_block", id)));
			}
		}
	}
	
	private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(Chess.MODID, "item/" + item.getId().getPath()));
	}
	
	public void evenSimplerBlockItem(Block block) {
		this.withExistingParent(Chess.MODID + ":" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath(),
				modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath()));
	}
	
	private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/handheld")).texture("layer0",
				new ResourceLocation(Chess.MODID,"item/" + item.getId().getPath()));
	}
	
	private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(Chess.MODID,"item/" + item.getId().getPath()));
	}
	
	private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
		return withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(Chess.MODID,"block/" + item.getId().getPath()));
	}
}
