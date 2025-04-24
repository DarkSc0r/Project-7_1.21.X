package net.darksc0r.project7.worldgen;

import net.darksc0r.project7.Project7;
import net.darksc0r.project7.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NICKEL_ORE_KEY = registerKey("nickel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ALUMINUM_ORE_KEY = registerKey("aluminum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LEAD_ORE_KEY = registerKey("lead_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // CF -> PF -> BM
        RuleTest stoneReplacables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldTinOres = List.of(
                OreConfiguration.target(stoneReplacables, ModBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.TIN_DEEPSLATE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldNickelOres = List.of(
                OreConfiguration.target(stoneReplacables, ModBlocks.NICKEL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.NICKEL_DEEPSLATE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldAluminumOres = List.of(
                OreConfiguration.target(stoneReplacables, ModBlocks.ALUMINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.ALUMINUM_DEEPSLATE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldLeadOres = List.of(
                OreConfiguration.target(stoneReplacables, ModBlocks.LEAD_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplacables, ModBlocks.LEAD_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_TIN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTinOres, 9));
        register(context, OVERWORLD_NICKEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNickelOres, 9));
        register(context, OVERWORLD_ALUMINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAluminumOres, 18));
        register(context, OVERWORLD_LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLeadOres, 20));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Project7.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
