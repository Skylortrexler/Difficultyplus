package website.skylorbeck.minecraft.difficultyplus.client;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import website.skylorbeck.minecraft.difficultyplus.ModConfig;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class DifficultyplusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AutoConfig.getGuiRegistry(ModConfig.class);
    }
}
