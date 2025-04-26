package net.darksc0r.project7.block.entity;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Project7.MOD_ID);


    public static final Supplier<BlockEntityType<CrudeKilnBlockEntity>> CRUDE_KILN_BE =
            BLOCK_ENTITIES.register("growth_chamber_be", () -> BlockEntityType.Builder.of(
                    CrudeKilnBlockEntity::new, ModBlocks.CRUDE_KILN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
