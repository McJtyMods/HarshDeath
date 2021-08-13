package mcjty.harshdeath.setup;

import mcjty.harshdeath.objects.DeathEffect;
import mcjty.harshdeath.objects.RejuvenationPotion;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static mcjty.harshdeath.HarshDeath.MODID;

public class Registration {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void register() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EFFECTS.register(bus);
        ITEMS.register(bus);
    }

    public static final RegistryObject<Effect> DEATH_EFFECT1 = EFFECTS.register("death1", () -> new DeathEffect("d88dc14c-fc10-11eb-9a03-0242ac130003", -0.2f));
    public static final RegistryObject<Effect> DEATH_EFFECT2 = EFFECTS.register("death2", () -> new DeathEffect("eb91003a-fc2c-11eb-9a03-0242ac130003", -0.4f));
    public static final RegistryObject<Effect> DEATH_EFFECT3 = EFFECTS.register("death3", () -> new DeathEffect("ef5890a2-fc2c-11eb-9a03-0242ac130003", -0.6f));
    public static final RegistryObject<Effect> DEATH_EFFECT4 = EFFECTS.register("death4", () -> new DeathEffect("f2dfe432-fc2c-11eb-9a03-0242ac130003", -0.8f));
    public static final RegistryObject<Effect> DEATH_EFFECT5 = EFFECTS.register("death5", () -> new DeathEffect("773188ee-fc37-11eb-9a03-0242ac130003", -0.95f));

    public static final RegistryObject<RejuvenationPotion> REJUVENATION_POTION = ITEMS.register("rejuvenation_potion", RejuvenationPotion::new);
}
