package website.skylorbeck.minecraft.difficultyplus;

import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

public interface ServerWorldAccessor {
    float getChanceToUpgradeMob();
    float getTotalXPGained();
    void addTotalXPGained(int i);
}
