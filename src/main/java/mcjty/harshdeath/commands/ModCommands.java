package mcjty.harshdeath.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import mcjty.harshdeath.HarshDeath;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class ModCommands {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> commands = dispatcher.register(
                Commands.literal(HarshDeath.MODID)
                        .then(CmdReset.register(dispatcher))
        );

        dispatcher.register(Commands.literal("hd").redirect(commands));
    }

}
