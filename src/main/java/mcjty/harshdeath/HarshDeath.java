package mcjty.harshdeath;


import mcjty.harshdeath.setup.Config;
import mcjty.harshdeath.setup.ModSetup;
import mcjty.harshdeath.setup.Registration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HarshDeath.MODID)
public class HarshDeath {

    public static final String MODID = "harshdeath";

    public static ModSetup setup = new ModSetup();

    public HarshDeath() {
        Config.register();
        Registration.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLCommonSetupEvent event) -> setup.init());
    }
}
