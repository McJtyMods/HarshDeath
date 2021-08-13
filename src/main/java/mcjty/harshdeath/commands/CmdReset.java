package mcjty.harshdeath.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class CmdReset {

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("reset")
                .requires(cs -> cs.hasPermission(2))
                .executes(CmdReset::reset);
    }

    private static int reset(CommandContext<CommandSource> context) {
        return 0;
    }
}
