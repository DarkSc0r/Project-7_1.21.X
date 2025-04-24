package net.darksc0r.project7.datagen;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModBlocks;
import net.darksc0r.project7.registry.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
//        List<ItemLike> STEEL_SMELTABLES = List.of(ModItems.RAW_STEEL,
//                ModBlocks.STEEL_ORE, ModBlocks.STEEL_DEEPSLATE_ORE);

        List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN,
                ModBlocks.TIN_ORE, ModBlocks.TIN_DEEPSLATE_ORE);

        List<ItemLike> NICKEL_SMELTABLES = List.of(ModItems.RAW_NICKEL,
                ModBlocks.NICKEL_ORE, ModBlocks.NICKEL_DEEPSLATE_ORE);

        List<ItemLike> ALUMINUM_SMELTABLES = List.of(ModItems.RAW_ALUMINUM,
                ModBlocks.ALUMINUM_ORE, ModBlocks.ALUMINUM_DEEPSLATE_ORE);

        List<ItemLike> LEAD_SMELTABLES = List.of(ModItems.RAW_LEAD,
                ModBlocks.LEAD_ORE, ModBlocks.LEAD_DEEPSLATE_ORE);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.STEEL.get())
                .unlockedBy("has_steel", has(ModItems.STEEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TIN.get())
                .unlockedBy("has_tin", has(ModItems.TIN)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NICKEL_BLOCK.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.NICKEL.get())
                .unlockedBy("has_nickel", has(ModItems.NICKEL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALUMINUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALUMINUM.get())
                .unlockedBy("has_aluminum", has(ModItems.ALUMINUM)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LEAD_BLOCK.get())
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModItems.LEAD.get())
                .unlockedBy("has_lead", has(ModItems.LEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHARCOAL_BRIQUETTE.get(), 4)
                .pattern("CCC")
                .pattern(" L ")
                .define('L', Items.CLAY_BALL)
                .define('C', Items.CHARCOAL)
                .unlockedBy("has_clay", has(Items.CLAY_BALL))
                .unlockedBy("has_charcoal", has(Items.CHARCOAL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MACHINE_CASING.get(), 3)
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .define('S', ModItems.STEEL.get())
                .define('G', Items.GLASS)
                .unlockedBy("has_steel", has(ModItems.STEEL))
                .unlockedBy("has_glass", has(Items.GLASS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRUDE_KILN.get())
                .pattern("BCB")
                .pattern("RMR")
                .pattern("BCB")
                .define('B', Items.BRICK)
                .define('M', Items.FURNACE)
                .define('R', Items.REDSTONE)
                .define('C', Items.COBBLESTONE)
                .unlockedBy("has_brick", has(Items.BRICK))
                .unlockedBy("has_furnace", has(Items.FURNACE))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_GEAR.get())
                        .pattern(" C ")
                        .pattern("C C")
                        .pattern(" C ")
                        .define('C', Items.COBBLESTONE)
                        .unlockedBy("has_cobblestone", has(Items.COBBLESTONE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN.get(), 9)
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_tin_block", has(ModBlocks.TIN_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NICKEL.get(), 9)
                .requires(ModBlocks.NICKEL_BLOCK)
                .unlockedBy("has_nickel_block", has(ModBlocks.NICKEL_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALUMINUM.get(), 9)
                .requires(ModBlocks.ALUMINUM_BLOCK)
                .unlockedBy("has_aluminum_block", has(ModBlocks.ALUMINUM_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LEAD.get(), 9)
                .requires(ModBlocks.LEAD_BLOCK)
                .unlockedBy("has_lead_block", has(ModBlocks.LEAD_BLOCK)).save(recipeOutput);

//        oreSmelting(recipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL.get(), 0.25f, 750, "steel");
//        oreBlasting(recipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL.get(), 0.25f, 500, "steel");

        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN.get(), 0.25f, 750, "tin");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN.get(), 0.25f, 500, "tin");

        oreSmelting(recipeOutput, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL.get(), 0.25f, 750, "nickel");
        oreBlasting(recipeOutput, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL.get(), 0.25f, 500, "nickel");

        oreSmelting(recipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM.get(), 0.25f, 750, "aluminum");
        oreBlasting(recipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM.get(), 0.25f, 500, "aluminum");

        oreSmelting(recipeOutput, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD.get(), 0.25f, 750, "lead");
        oreBlasting(recipeOutput, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD.get(), 0.25f, 500, "lead");


    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Project7.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
