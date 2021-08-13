package mcjty.harshdeath.datagen;

import mcjty.harshdeath.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(Registration.REJUVENATION_POTION.get())
                .define('r', Tags.Items.DUSTS_REDSTONE)
                .define('d', Tags.Items.GEMS_DIAMOND)
                .define('e', Tags.Items.GEMS_EMERALD)
                .define('l', Tags.Items.GEMS_LAPIS)
                .define('w', Items.WATER_BUCKET)
                .define('b', Items.GLASS_BOTTLE)
                .unlockedBy("redstone", has(Items.REDSTONE))
                .pattern("rwr").pattern("ebl").pattern("rdr")
                .group("potions").save(consumer);
    }
}
