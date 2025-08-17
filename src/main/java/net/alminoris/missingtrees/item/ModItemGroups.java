package net.alminoris.missingtrees.item;

import net.alminoris.missingtrees.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Arrays;

import static net.alminoris.missingtrees.util.helper.ModBlockSetsHelper.*;

public class ModItemGroups
{
    public static final ItemGroup MISSING_TREES_TAB = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(net.alminoris.missingtrees.MissingTrees.MOD_ID, "missingtreestab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.missingtreestab"))
                    .icon(() -> new ItemStack(Blocks.ACACIA_SAPLING)).entries((displayContext, entries) ->
                    {
                        for (String name : WOOD_NAMES)
                        {
                            if (!name.equals("azalea"))
                            {
                                entries.add(WOODEN_SAPLINGS.get(name));
                            }
                            else
                            {
                                entries.add(Blocks.AZALEA);
                                entries.add(Blocks.FLOWERING_AZALEA);
                            }
                            if (name.equals("azalea"))
                            {
                                entries.add(Blocks.AZALEA_LEAVES);
                                entries.add(Blocks.FLOWERING_AZALEA_LEAVES);
                            }
                            else
                            {
                                entries.add(LEAVES.get(name));
                                if (name.equals("apple")) entries.add(ModBlocks.APPLE_FRUIT_LEAVES);
                            }
                            entries.add(LOGS.get(name));
                            entries.add(WOODS.get(name));
                            entries.add(STRIPPED_LOGS.get(name));
                            entries.add(STRIPPED_WOODS.get(name));
                            entries.add(WOODEN_PLANKS.get(name));
                            entries.add(WOODEN_SLABS.get(name));
                            entries.add(WOODEN_STAIRS.get(name));
                            entries.add(WOODEN_FENCES.get(name));
                            entries.add(WOODEN_FENCE_GATES.get(name));
                            entries.add(WOODEN_DOORS.get(name));
                            entries.add(WOODEN_TRAPDOORS.get(name));
                            entries.add(WOODEN_BUTTONS.get(name));
                            entries.add(WOODEN_PRESSURE_PLATES.get(name));
                            entries.add(WOODEN_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_HANGING_SIGN_ITEMS.get(name));
                            entries.add(WOODEN_BOATS.get(name));
                            entries.add(WOODEN_CHEST_BOATS.get(name));
                        }
                    }).build());

    public static void registerItemGroups()
    {

    }
}