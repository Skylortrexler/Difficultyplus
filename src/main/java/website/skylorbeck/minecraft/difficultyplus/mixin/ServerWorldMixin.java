package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import website.skylorbeck.minecraft.difficultyplus.ServerWorldAccessor;
import website.skylorbeck.minecraft.difficultyplus.cardinal.IXPTracker;

@Mixin(ServerWorld.class)
public class ServerWorldMixin implements ServerWorldAccessor {
    public float chanceToUpgradeMob = 0;
    public int totalXPGained = 0;

    @Override
    public float getChanceToUpgradeMob() {
        return chanceToUpgradeMob;
    }

    @Override
    public float getTotalXPGained() {
        return totalXPGained;
    }

    @Override
    public void addTotalXPGained(int i) {
        this.totalXPGained+=i;
    }
}
