package net.alminoris.missingtrees.world.tree;

import net.alminoris.missingtrees.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Optional;

import static net.alminoris.missingtrees.util.helper.ModBlockSetsHelper.WOOD_NAMES;

public class ModSaplingGenerators
{
    public static final Dictionary<String, RegistryKey<ConfiguredFeature<?, ?>>> keys = new Hashtable<>()
    {{
        put("apple", ModConfiguredFeatures.APPLE_KEY);
    }};

    public static final Dictionary<String, SaplingGenerator> saplingGenerators = new Hashtable<>()
    {{
        for(String name : Arrays.stream(WOOD_NAMES).filter(name -> !name.equals("azalea")).toArray(String[]::new))
        {
            put(name, new SaplingGenerator(name, 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(keys.get(name)),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()));
        }
    }};
}