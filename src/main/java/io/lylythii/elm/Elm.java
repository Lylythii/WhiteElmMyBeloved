package io.lylythii.elm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("WeakerAccess")
@Mod(modid = Elm.MOD_ID, name = Elm.NAME, version = Elm.VERSION, dependencies = "required-after:tfc")
public class Elm {
	
    public static final String MOD_ID = "elm";
    public static final String NAME = "White Elm My Beloved";
    public static final String VERSION = "@VERSION@";
    public static final String SIGNING_KEY = "@FINGERPRINT@";

    @Instance
	private static Elm INSTANCE;
    
    private final Logger log = LogManager.getLogger(MOD_ID);
    
    public static Logger getLog() {
		return INSTANCE.log;
	}
}
