package net.darksc0r.project7.tabs;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModBlocks;
import net.darksc0r.project7.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Project7.MODID);

    public static final Supplier<CreativeModeTab> PROJECT7_TAB = CREATIVE_MODE_TAB.register("project7_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
                    .title(Component.translatable("creativetab.project7.project7_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                      // Steel
                      output.accept(ModItems.STEEL);
                      output.accept(ModItems.RAW_STEEL);
                      output.accept(ModBlocks.STEEL_BLOCK);
                      output.accept(ModBlocks.STEEL_ORE);
                      output.accept(ModBlocks.STEEL_DEEPSLATE_ORE);
                      // Tin
                      output.accept(ModItems.TIN);
                      output.accept(ModItems.RAW_TIN);
                      output.accept(ModBlocks.TIN_BLOCK);
                      output.accept(ModBlocks.TIN_ORE);
                      output.accept(ModBlocks.TIN_DEEPSLATE_ORE);
                      // Nickel
                      output.accept(ModItems.NICKEL);
                      output.accept(ModItems.RAW_NICKEL);
                      output.accept(ModBlocks.NICKEL_BLOCK);
                      output.accept(ModBlocks.NICKEL_ORE);
                      output.accept(ModBlocks.NICKEL_DEEPSLATE_ORE);
                      // Aluminum
                      output.accept(ModItems.ALUMINUM);
                      output.accept(ModItems.RAW_ALUMINUM);
                      output.accept(ModBlocks.ALUMINUM_DEEPSLATE_ORE);
                      output.accept(ModBlocks.ALUMINUM_ORE);
                      output.accept(ModBlocks.ALUMINUM_BLOCK);
                      // Lead
                      output.accept(ModItems.LEAD);
                      output.accept(ModItems.RAW_LEAD);
                      output.accept(ModBlocks.LEAD_DEEPSLATE_ORE);
                      output.accept(ModBlocks.LEAD_ORE);
                      output.accept(ModBlocks.LEAD_BLOCK);
                      // Special Items
                      output.accept(ModItems.WRENCH);
                      //special blocks.
                      output.accept(ModBlocks.PIPE);
                      output.accept(ModBlocks.MACHINE_CASING);
                    }).build());

    /*IF ADDING A NEW CREATIVE MODE TAB
    DO THIS:
    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Project7.MOD_ID, "project7_tab)

    Make sure to add this before your .title()
    */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
