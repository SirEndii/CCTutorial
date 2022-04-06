package de.srendi.cctutorial.cctutorial;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cctutorial")
public class CCtutorial {

    // Our mod id
    public static final String MODID = "cctutorial";

    public CCtutorial() {
        Registration.register();
        // Register ourselves for server and other game events we are interested in. Currently, we do not use any events
        MinecraftForge.EVENT_BUS.register(this);
    }
}
