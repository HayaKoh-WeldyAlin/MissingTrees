package net.alminoris.missingtrees;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.alminoris.missingtrees.entity.ModBoats;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static net.alminoris.missingtrees.util.helper.ModBlockSetsHelper.*;

public class MissingTreesClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        for (String name : WOOD_NAMES)
        {
            if (!name.equals("azalea"))
            {
                BlockRenderLayerMap.INSTANCE.putBlock(LEAVES.get(name), RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_SAPLINGS.get(name), RenderLayer.getCutout());
            }
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_DOORS.get(name), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(WOODEN_TRAPDOORS.get(name), RenderLayer.getCutout());
            TerraformBoatClientHelper.registerModelLayers(ModBoats.boatIDs.get(name), false);
        }
    }
}