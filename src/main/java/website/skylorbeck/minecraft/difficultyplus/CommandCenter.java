package website.skylorbeck.minecraft.difficultyplus;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import website.skylorbeck.minecraft.difficultyplus.cardinal.DifficultyPlusCardinal;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class CommandCenter {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("difficultyplus").requires(cs -> cs.hasPermissionLevel(2))
                        .then(literal("clear")
                                .executes((command) -> {
                                    resetWorldXP(command.getSource().getWorld(),0);
                                    command.getSource().sendFeedback(new TranslatableText("command.difficultyplus.cleared"), true);
                                    return 1;
                                }))
        );
        dispatcher.register(
                literal("difficultyplus").requires(cs -> cs.hasPermissionLevel(2))
                        .then(literal("set")
                        .then(argument("percent", IntegerArgumentType.integer())
                                .executes((command) -> {
                                    int value =(int)  ((IntegerArgumentType.getInteger(command,"percent") * 0.01f)/ Declarar.xpInfluence);
                                    resetWorldXP(command.getSource().getWorld(),value);
                                    command.getSource().sendFeedback(new TranslatableText("command.difficultyplus.set").append(Text.of(" "+ value)), true);
                                    return 1;
                                }))
        ));
        dispatcher.register(
                literal("difficultyplus").requires(cs -> cs.hasPermissionLevel(0))
                        .then(literal("get")
                                .executes((command) -> {
                                    World world = command.getSource().getWorld();
                                    command.getSource().sendFeedback(new TranslatableText("command.difficultyplus.get").append(Text.of(" "+100* MathHelper.clamp((DifficultyPlusCardinal.WorldXP.get(world).getTotalXP() * Declarar.xpInfluence) * (world.getPlayers().size() * Declarar.playerInfluence), 0, Declarar.chanceCap)+"%")), true);
                                    return 1;
                                }))
        );
    }
    private static void resetWorldXP(World serverWorld, int amount) {
        for (World world:serverWorld.getServer().getWorlds()) {
            DifficultyPlusCardinal.WorldXP.get(world).setTotalXP(amount);
            DifficultyPlusCardinal.WorldXP.sync(world);
        }
    }
}