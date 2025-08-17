package net.alminoris.missingtrees.world;

import net.alminoris.missingtrees.util.helper.ModBlockSetsHelper;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

import java.util.List;

public class ModPlacedFeatures
{
    public static final RegistryKey<PlacedFeature> APPLE_PLACED_KEY = registerKey("apple_placed");

    public static void bootstrap(Registerable<PlacedFeature> context)
    {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, APPLE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(0, 0.1f, 1),
                        ModBlockSetsHelper.WOODEN_SAPLINGS.get("apple")));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(net.alminoris.missingtrees.MissingTrees.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}