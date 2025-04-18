package net.darksc0r.project7.tabs;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModBlocks;
import net.darksc0r.project7.registry.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
                    .title(Component.translatable("creativetab.project7.project7"))
                    .displayItems((itemDisplayParameters, output) -> {

                      // Items
                      output.accept(ModItems.STEEL);
                      output.accept(ModItems.RAW_STEEL);
                      output.accept(ModItems.TIN);
                      output.accept(ModItems.RAW_TIN);
                      output.accept(ModItems.NICKEL);
                      output.accept(ModItems.RAW_NICKEL);
                      output.accept(ModItems.ALUMINUM);
                      output.accept(ModItems.RAW_ALUMINUM);

                      //special blocks.
                      output.accept(ModBlocks.PIPE);

                      //blocks
                      output.accept(ModBlocks.STEEL_BLOCK);
                      output.accept(ModBlocks.STEEL_ORE);
                      output.accept(ModBlocks.STEEL_DEEPSLATE_ORE);
                      output.accept(ModBlocks.TIN_BLOCK);
                      output.accept(ModBlocks.TIN_ORE);
                      output.accept(ModBlocks.TIN_DEEPSLATE_ORE);
                      output.accept(ModBlocks.NICKEL_BLOCK);
                      output.accept(ModBlocks.NICKEL_ORE);
                      output.accept(ModBlocks.NICKEL_DEEPSLATE_ORE);
                      output.accept(ModBlocks.ALUMINUM_DEEPSLATE_ORE);
                      output.accept(ModBlocks.ALUMINUM_ORE);
                      output.accept(ModBlocks.ALUMINUM_BLOCK);

                    }).build());

    /*IF ADDING A NEW CREATIVE MODE TAB
    DO THIS:
    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Project7.MOD_ID, "project7_tab)

    */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
