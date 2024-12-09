package net.caseykat.chess.datagen;

import net.caseykat.chess.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
	public ModRecipeProvider(PackOutput pOutput) {
		super(pOutput);
	}
	
	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
//		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_BISHOP_BLOCK.get())
//				.pattern("#")
//				.pattern("#")
//				.define('#', Items.BLACK_CONCRETE)
//				.save(pWriter);
	}
}
