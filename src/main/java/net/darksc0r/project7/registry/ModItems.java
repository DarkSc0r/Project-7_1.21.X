package net.darksc0r.project7.registry;

import net.darksc0r.project7.Project7;

import net.darksc0r.project7.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.darksc0r.project7.item.custom.WrenchItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Project7.MODID);

    public static final DeferredItem<Item> STEEL = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.project7.steel.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> RAW_STEEL = ITEMS.register("raw_steel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NICKEL = ITEMS.register("nickel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_NICKEL = ITEMS.register("raw_nickel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
            () -> new Item((new Item.Properties())));
    public static final DeferredItem<Item> LEAD = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item((new Item.Properties())));



    // Custom Items
    public static final DeferredItem<Item> CHARCOAL_BRIQUETTE = ITEMS.register("charcoal_briquette",
            () -> new FuelItem(new Item.Properties(), 2400));

    public static final DeferredItem<BlockItem> PIPE_ITEM = ITEMS.register("pipe",
            () -> new BlockItem(ModBlocks.PIPE.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CRUDE_CRUSHER = ITEMS.register("crude_crusher",
            () -> new BlockItem(ModBlocks.CRUDE_CRUSHER.get(), new Item.Properties()));

    public static final DeferredItem<Item> WRENCH = ITEMS.register("wrench_item",
            () -> new WrenchItem(new Item.Properties().durability(128)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
