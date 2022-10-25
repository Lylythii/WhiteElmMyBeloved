package io.lylythii.elm.types;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.api.util.ITreeGenerator;
import net.dries007.tfc.world.classic.worldgen.trees.*;
import io.lylythii.elm.Elm;
import io.lylythii.elm.world.worldgen.TreeGenRandom;

import static net.dries007.tfc.types.DefaultTrees.*;
import static net.dries007.tfc.util.Helpers.getNull;

import static io.lylythii.elm.Elm.MOD_ID;

@SuppressWarnings({"unused", "WeakerAccess"})
@Mod.EventBusSubscriber(modid = Elm.MOD_ID)
public final class NewTrees
{

    public static final ResourceLocation WHITE_ELM = new ResourceLocation(MOD_ID, "white_elm");

    @SubscribeEvent
    public static void onPreRegisterRockCategory(TFCRegistryEvent.RegisterPreBlock<Tree> event)
    {
        event.getRegistry().registerAll(
            new Tree.Builder(WHITE_ELM, 140f, 360f, 3f, 20f, GEN_MEDIUM)
				.setHeight(16)
			.build()
        );
    }
}