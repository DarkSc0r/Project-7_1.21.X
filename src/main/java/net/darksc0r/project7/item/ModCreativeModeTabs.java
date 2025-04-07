package net.darksc0r.project7.item;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
                      output.accept(ModItems.STEEL);
                      output.accept(ModItems.RAW_STEEL);

                      output.accept(ModBlocks.STEEL_BLOCK);
                      output.accept(ModBlocks.STEEL_ORE);

                    }).build());

    /*IF ADDING A NEW CREATIVE MODE TAB
    DO THIS:
    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Project7.MOD_ID, "project7_tab)

    */
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
