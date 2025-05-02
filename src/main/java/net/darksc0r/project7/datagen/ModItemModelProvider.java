package net.darksc0r.project7.datagen;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Project7.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STEEL.get());
        basicItem(ModItems.RAW_STEEL.get());
        basicItem(ModItems.TIN.get());
        basicItem(ModItems.RAW_TIN.get());
        basicItem(ModItems.NICKEL.get());
        basicItem(ModItems.RAW_NICKEL.get());
        basicItem(ModItems.ALUMINUM.get());
        basicItem(ModItems.RAW_ALUMINUM.get());
        basicItem(ModItems.LEAD.get());
        basicItem(ModItems.RAW_LEAD.get());
        basicItem(ModItems.SILVER.get());
        basicItem(ModItems.CHARCOAL_BRIQUETTE.get());
        basicItem(ModItems.WRENCH.get());
        basicItem(ModItems.STONE_GEAR.get());
    }
}
