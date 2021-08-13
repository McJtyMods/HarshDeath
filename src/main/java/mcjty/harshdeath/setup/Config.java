package mcjty.harshdeath.setup;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {

    public static final Builder SERVER_BUILDER = new Builder();

    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.IntValue HARSH_DEATH_DURATION;
    public static ForgeConfigSpec.EnumValue<DeathPenalty> HARSH_DEATH_PENALTY;


    public static void register() {
        SERVER_BUILDER.comment("General settings").push("general");

        HARSH_DEATH_DURATION = SERVER_BUILDER
                .comment("How long should the harsh death effect last")
                .defineInRange("harshDeathDuration", 32000, 0, Integer.MAX_VALUE);
        HARSH_DEATH_PENALTY = SERVER_BUILDER
                .comment("The penaltiy modifier on max health")
                .defineEnum("harshDeathPenalty", DeathPenalty.HARD);

        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }

}
