package net.darksc0r.project7.registry;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.block.custom.CrudeKilnBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Project7.MOD_ID);

    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

//    public static final DeferredBlock<Block> STEEL_ORE = registerBlock("steel_ore",
//            () -> new DropExperienceBlock(UniformInt.of(2, 4),
//                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
//
//    public static final DeferredBlock<Block> STEEL_DEEPSLATE_ORE = registerBlock("steel_deepslate_ore",
//            () -> new DropExperienceBlock(UniformInt.of(3, 6),
//                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> TIN_DEEPSLATE_ORE = registerBlock("tin_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> NICKEL_BLOCK = registerBlock("nickel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> NICKEL_ORE = registerBlock("nickel_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> NICKEL_DEEPSLATE_ORE = registerBlock("nickel_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> ALUMINUM_ORE = registerBlock("aluminum_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> ALUMINUM_DEEPSLATE_ORE = registerBlock("aluminum_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> LEAD_DEEPSLATE_ORE = registerBlock("lead_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of().strength(5.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));


    //Custom blocks
//    public static final DeferredBlock<CrudePipeBlock> CRUDE_PIPE = BLOCKS.register("crude_pipe",
//            () -> new CrudePipeBlock(BlockBehaviour.Properties.of().strength(1.5F).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> MACHINE_CASING = registerBlock("machine_casing",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).noOcclusion()
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> CRUDE_KILN = registerBlock("crude_kiln",
            () -> new CrudeKilnBlock(BlockBehaviour.Properties.of()));
//
//    public static final DeferredBlock<CrudeCrusherBlock> CRUDE_CRUSHER = BLOCKS.register("crude_crusher",
//            () -> new CrudeCrusherBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));


    private static<T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
