package website.skylorbeck.minecraft.difficultyplus;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import website.skylorbeck.minecraft.skylorlib.MidnightConfig;

public class Difficultyplus implements ModInitializer {

    @Override
    public void onInitialize() {
        MidnightConfig.init(Declarar.MODID,ModConfig.class);//register config asap to prevent errors down the line
        Declarar.UpdateXPRates();
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment)-> {
            CommandCenter.register(dispatcher);
        });
    }
}
