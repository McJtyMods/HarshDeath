package mcjty.harshdeath.setup;

import mcjty.harshdeath.ForgeEventHandlers;
import mcjty.harshdeath.HarshDeath;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModSetup {

    private Logger logger;

    public void init() {
        logger = LogManager.getLogger(HarshDeath.MODID);

        MinecraftForge.EVENT_BUS.register(new ForgeEventHandlers());
    }

    public Logger getLogger() {
        return logger;
    }
}
