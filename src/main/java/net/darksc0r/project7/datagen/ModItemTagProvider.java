package net.darksc0r.project7.datagen;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModItems;
import net.darksc0r.project7.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Project7.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.CRUSHABLE_ITEMS)
                .add(ModItems.RAW_STEEL.get())
                .add(ModItems.RAW_TIN.get())
                .add(ModItems.RAW_NICKEL.get())
                .add(ModItems.RAW_ALUMINUM.get())
                .add(ModItems.RAW_LEAD.get());
    }
}
