package website.skylorbeck.minecraft.difficultyplus;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import website.skylorbeck.minecraft.skylorlib.MidnightConfig;

public class ConfigEntry implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> MidnightConfig.getScreen(parent,Declarar.MODID);
    }
}
