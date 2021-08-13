package mcjty.harshdeath.objects;

import mcjty.harshdeath.setup.Registration;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RejuvenationPotion extends Item {

    public RejuvenationPotion() {
        super(new Item.Properties().tab(ItemGroup.TAB_BREWING).stacksTo(1));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World level, List<ITextComponent> list, ITooltipFlag flags) {
        super.appendHoverText(stack, level, list, flags);
        list.add(new TranslationTextComponent("message.harshdeath.rejuvenation_potion"));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World level, LivingEntity entity) {
        if (!(entity instanceof ServerPlayerEntity)) {
            return stack;
        }
        ServerPlayerEntity player = (ServerPlayerEntity) entity;
        CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);

        player.removeEffect(Registration.DEATH_EFFECT1.get());
        player.removeEffect(Registration.DEATH_EFFECT2.get());
        player.removeEffect(Registration.DEATH_EFFECT3.get());
        player.removeEffect(Registration.DEATH_EFFECT4.get());
        player.removeEffect(Registration.DEATH_EFFECT5.get());

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.abilities.instabuild) {
            stack.shrink(1);
        }

        if (!player.abilities.instabuild) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }
            player.inventory.add(new ItemStack(Items.GLASS_BOTTLE));
        }

        return stack;
    }

    protected ItemStack getEmptySuccessItem(ItemStack stack, PlayerEntity player) {
        return !player.abilities.instabuild ? new ItemStack(Items.BUCKET) : stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ActionResult<ItemStack> use(World level, PlayerEntity player, Hand hand) {
        return DrinkHelper.useDrink(level, player, hand);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}

