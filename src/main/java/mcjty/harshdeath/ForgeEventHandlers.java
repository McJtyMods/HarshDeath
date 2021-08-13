package mcjty.harshdeath;

import mcjty.harshdeath.commands.ModCommands;
import mcjty.harshdeath.setup.Config;
import mcjty.harshdeath.setup.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static mcjty.harshdeath.setup.Config.HARSH_DEATH_DURATION;

public class ForgeEventHandlers {

    @SubscribeEvent
    public void registerCommands(RegisterCommandsEvent event) {
        ModCommands.register(event.getDispatcher());
    }


    @SubscribeEvent
    public void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
        if (!event.isEndConquered()) {
            PlayerEntity player = event.getPlayer();
            Effect effect = Registration.DEATH_EFFECT1.get();
            switch (Config.HARSH_DEATH_PENALTY.get()) {
                case WHIMP:
                    return;
                case EASY:
                    effect = Registration.DEATH_EFFECT1.get();
                    break;
                case NORMAL:
                    effect = Registration.DEATH_EFFECT2.get();
                    break;
                case HARD:
                    effect = Registration.DEATH_EFFECT3.get();
                    break;
                case BRUTAL:
                    effect = Registration.DEATH_EFFECT4.get();
                    break;
                case SAVAGE:
                    effect = Registration.DEATH_EFFECT5.get();
                    break;
            }
            player.addEffect(new EffectInstance(effect, HARSH_DEATH_DURATION.get(), 0));
        }
    }
}