package net.darksc0r.project7.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record CrudeKilnRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CrudeKilnRecipeInput> {
    // Read in a json file
    // 

    @Override
    public boolean matches(CrudeKilnRecipeInput crudeKilnRecipeInput, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(CrudeKilnRecipeInput crudeKilnRecipeInput, HolderLookup.Provider provider) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return false;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }
}
