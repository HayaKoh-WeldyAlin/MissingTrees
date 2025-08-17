package net.alminoris.missingtrees.mixin;

import net.alminoris.missingtrees.MissingTrees;
import net.alminoris.missingtrees.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.intellij.lang.annotations.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Optional;

@Mixin(SaplingGenerator.class)
public class SaplingGeneratorMixin
{
    @Shadow
    @Final
    @Mutable
    public static SaplingGenerator AZALEA;

    static
    {
        AZALEA = new SaplingGenerator("azalea", Optional.empty(), Optional.of(ModConfiguredFeatures.AZALEA_KEY), Optional.empty());
    }
}