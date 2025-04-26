package net.darksc0r.project7.datagen;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Project7.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Ores and Their Blocks
        blockWithItem(ModBlocks.STEEL_BLOCK);
//        blockWithItem(ModBlocks.STEEL_ORE);
//        blockWithItem(ModBlocks.STEEL_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.TIN_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.NICKEL_BLOCK);
        blockWithItem(ModBlocks.NICKEL_ORE);
        blockWithItem(ModBlocks.NICKEL_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.ALUMINUM_ORE);
        blockWithItem(ModBlocks.ALUMINUM_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.LEAD_BLOCK);
        blockWithItem(ModBlocks.LEAD_ORE);
        blockWithItem(ModBlocks.LEAD_DEEPSLATE_ORE);

        // Custom Items
        blockWithItem(ModBlocks.MACHINE_CASING);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
//
//    private void blockWithSpecialItem(DeferredBlock<?> deferredBlock) {
//        block
//    }
}
