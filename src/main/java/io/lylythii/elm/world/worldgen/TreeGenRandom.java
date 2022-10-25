package io.lylythii.elm.world.worldgen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.api.util.ITreeGenerator;
import net.dries007.tfc.objects.blocks.wood.BlockLogTFC;
import net.dries007.tfc.world.classic.StructureHelper;

import io.lylythii.elm.Elm;

import static net.dries007.tfc.objects.blocks.wood.BlockLogTFC.PLACED;

public class TreeGenRandom implements ITreeGenerator
{
    private static final PlacementSettings settingsFull = StructureHelper.getDefaultSettings();
    private static final PlacementSettings settingsWeak = StructureHelper.getDefaultSettings().setIntegrity(0.5f);
    private final int heightMin;
    private final int heightRange;
    private final int variant;

    public TreeGenRandom(int heightMin, int heightRange, int variant)
    {
        this.heightMin = heightMin;
        this.heightRange = heightRange;
        this.variant = variant;
    }

    @Override
    public void generateTree(TemplateManager manager, World world, BlockPos pos, Tree tree, Random rand, boolean isWorldGen)
    {
        int tmp = rand.nextInt(variant) + 1;

        ResourceLocation base = new ResourceLocation(tree.getRegistryName() + "/base_" + tmp);
        ResourceLocation overlay = new ResourceLocation(tree.getRegistryName() + "/overlay_" + tmp);

        Template structureBase = manager.get(world.getMinecraftServer(), base);
        Template structureOverlay = manager.get(world.getMinecraftServer(), overlay);

        if (structureBase == null)
        {
            Elm.getLog().warn("Elm: Unable to find a template for " + base.toString());
            return;
        }

        int height = heightMin + (heightRange > 0 ? rand.nextInt(heightRange) : 0);

        BlockPos size = structureBase.getSize();
        pos = pos.add(-size.getX() / 2, height, -size.getZ() / 2);

        StructureHelper.addStructureToWorld(world, pos, structureBase, settingsFull);
        if (structureOverlay != null)
        {
            StructureHelper.addStructureToWorld(world, pos, structureOverlay, settingsWeak);
        }

        final IBlockState log = BlockLogTFC.get(tree).getDefaultState().withProperty(PLACED, false);
        for (int i = 0; i < height; i++)
            world.setBlockState(pos.add(size.getX() / 2, i - height, size.getZ() / 2), log);
    }

}