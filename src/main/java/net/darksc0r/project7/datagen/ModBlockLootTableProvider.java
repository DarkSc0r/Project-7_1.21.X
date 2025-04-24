package net.darksc0r.project7.datagen;

import net.darksc0r.project7.registry.ModBlocks;
import net.darksc0r.project7.registry.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.STEEL_BLOCK.get());
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.NICKEL_BLOCK.get());
        dropSelf(ModBlocks.ALUMINUM_BLOCK.get());
        dropSelf(ModBlocks.CRUDE_KILN.get());
        dropSelf(ModBlocks.MACHINE_CASING.get());
        dropSelf(ModBlocks.LEAD_BLOCK.get());

//        add(ModBlocks.STEEL_ORE.get(),
//                block -> createOreDrop(ModBlocks.STEEL_ORE.get(), ModItems.RAW_STEEL.get()));
//        add(ModBlocks.STEEL_DEEPSLATE_ORE.get(),
//                block -> createMultipleOreDrops(ModBlocks.STEEL_DEEPSLATE_ORE.get(), ModItems.RAW_STEEL.get(), 3, 6));

        add(ModBlocks.TIN_ORE.get(),
                block -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));
        add(ModBlocks.TIN_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.TIN_DEEPSLATE_ORE.get(), ModItems.RAW_TIN.get(), 3, 6));

        add(ModBlocks.NICKEL_ORE.get(),
                block -> createOreDrop(ModBlocks.NICKEL_ORE.get(), ModItems.RAW_NICKEL.get()));
        add(ModBlocks.NICKEL_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.NICKEL_DEEPSLATE_ORE.get(), ModItems.RAW_NICKEL.get(), 3, 6));

        add(ModBlocks.ALUMINUM_ORE.get(),
                block -> createOreDrop(ModBlocks.ALUMINUM_ORE.get(), ModItems.RAW_ALUMINUM.get()));
        add(ModBlocks.ALUMINUM_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ALUMINUM_DEEPSLATE_ORE.get(), ModItems.RAW_ALUMINUM.get(), 3, 6));

        add(ModBlocks.LEAD_ORE.get(),
                block -> createOreDrop(ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get()));
        add(ModBlocks.LEAD_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.LEAD_DEEPSLATE_ORE.get(), ModItems.RAW_LEAD.get(), 3, 6));



    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops){
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
