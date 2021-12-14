package website.skylorbeck.minecraft.difficultyplus.cardinal;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import website.skylorbeck.minecraft.difficultyplus.Declarar;

public class DifficultyPlusCardinal implements WorldComponentInitializer {
    public static final ComponentKey<XPTracker> WorldXP =
            ComponentRegistry.getOrCreate(Declarar.getIdentifier("worldxp"), XPTracker.class);

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(WorldXP, world -> {
            if (!world.getRegistryKey().equals(World.OVERWORLD) && world.getServer()!=null) {
                return WorldXP.get(world.getServer().getWorld(World.OVERWORLD));
            } else {
               return new XPTracker();
            }
        });
    }
}