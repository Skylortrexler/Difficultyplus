package website.skylorbeck.minecraft.difficultyplus.cardinal;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import website.skylorbeck.minecraft.difficultyplus.Declarar;

public class DifficultyPlusCardinal implements WorldComponentInitializer {
    public static final ComponentKey<XPTracker> WorldXP =
            ComponentRegistry.getOrCreate(Declarar.getIdentifier("worldxp"), XPTracker.class);

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(WorldXP, world -> {
               return new XPTracker();
        });
    }
}