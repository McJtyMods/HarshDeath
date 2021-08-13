package mcjty.harshdeath.datagen;

import mcjty.harshdeath.HarshDeath;
import mcjty.harshdeath.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, HarshDeath.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        getBuilder(Registration.REJUVENATION_POTION.get().getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/rejuvenation_potion");
    }

    @Override
    public String getName() {
        return "RFTools Control Item Models";
    }
}
