package net.darksc0r.project7.worldgen;

import net.darksc0r.project7.Project7;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_TIN_ORE = registerKey("add_tin_ore");
    public static final ResourceKey<BiomeModifier> ADD_NICKEL_ORE = registerKey("add_nickel_ore");
    public static final ResourceKey<BiomeModifier> ADD_ALUMINUM_ORE = registerKey("add_aluminum_ore");
    public static final ResourceKey<BiomeModifier> ADD_LEAD_ORE = registerKey("add_lead_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TIN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NICKEL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NICKEL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_ALUMINUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ALUMINUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LEAD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LEAD_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        /*
        EXAMPLE FOR INDIVIDUAL BIOMES

        context.register(ADD_TIN_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.SAVANA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TIN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

         */


    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Project7.MOD_ID, name));
    }

}
