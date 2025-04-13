package net.darksc0r.project7.registry;

import net.darksc0r.project7.Project7;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Project7.MODID);

    public static final DeferredItem<Item> STEEL = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_STEEL = ITEMS.register("raw_steel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN = ITEMS.register("tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NICKEL = ITEMS.register("nickel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_NICKEL = ITEMS.register("raw_nickel",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
