package net.darksc0r.project7.datagen;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Project7.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_ORE.get())
                .add(ModBlocks.STEEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.TIN_DEEPSLATE_ORE.get())
                .add(ModBlocks.NICKEL_BLOCK.get())
                .add(ModBlocks.NICKEL_ORE.get())
                .add(ModBlocks.NICKEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.ALUMINUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_ORE.get())
                .add(ModBlocks.LEAD_DEEPSLATE_ORE.get())
                .add(ModBlocks.CRUDE_CRUSHER.get())
                .add(ModBlocks.MACHINE_CASING.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.STEEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.TIN_DEEPSLATE_ORE.get())
                .add(ModBlocks.NICKEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.ALUMINUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.LEAD_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_ORE.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.NICKEL_BLOCK.get())
                .add(ModBlocks.NICKEL_ORE.get())
                .add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_ORE.get())
                .add(ModBlocks.CRUDE_CRUSHER.get())
                .add(ModBlocks.MACHINE_CASING.get());


    }
}
