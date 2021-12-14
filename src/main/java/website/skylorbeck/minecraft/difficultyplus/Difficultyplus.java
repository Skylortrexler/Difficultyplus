package website.skylorbeck.minecraft.difficultyplus;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.util.ActionResult;

public class Difficultyplus implements ModInitializer {

    @Override
    public void onInitialize() {
        ConfigHolder<ModConfig> configHolder = AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);//register config asap to prevent errors down the line
        configHolder.getConfig();
        Declarar.UpdateXPRates();
        configHolder.registerSaveListener((manager, data) ->{//listen for config file changes
            Declarar.UpdateXPRates();
            //gets settings that don't need a full restart to properly do.
            return ActionResult.SUCCESS;
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            CommandCenter.register(dispatcher);
        });
    }
}
//todo mob blacklist
