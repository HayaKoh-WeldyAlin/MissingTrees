package net.alminoris.missingtrees.world;

import net.alminoris.missingtrees.block.ModBlocks;
import net.alminoris.missingtrees.util.helper.ModBlockSetsHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.BendingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

public class ModConfiguredFeatures
{
    public static RegistryKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");

    public static RegistryKey<ConfiguredFeature<?, ?>> AZALEA_KEY = registerKey("azalea");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context)
    {
        register(context, APPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("apple")),
                new LargeOakTrunkPlacer(3, 7, 0),
                new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder().add(ModBlockSetsHelper.LEAVES.get("apple").getDefaultState(), 5).add(ModBlocks.APPLE_FRUIT_LEAVES.getDefaultState(), 2)
                ),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        register(context, AZALEA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlockSetsHelper.LOGS.get("azalea")),
                new BendingTrunkPlacer(4, 2, 0, 3, UniformIntProvider.create(1, 2)),
                new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder().add(Blocks.AZALEA_LEAVES.getDefaultState(), 3).add(Blocks.FLOWERING_AZALEA_LEAVES.getDefaultState(), 1)
                ),
                new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 50),
                new TwoLayersFeatureSize(1, 0, 1)
        ).dirtProvider(BlockStateProvider.of(Blocks.ROOTED_DIRT)).forceDirt().build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(net.alminoris.missingtrees.MissingTrees.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}