package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.minecraft.difficultyplus.cardinal.DifficultyPlusCardinal;
import website.skylorbeck.minecraft.difficultyplus.cardinal.XPTracker;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {

    @Shadow
    private int amount;

    @Inject(method = "onPlayerCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;addExperience(I)V"))
    private void logXPGains(PlayerEntity player, CallbackInfo ci) {
        if (!player.isCreative()) {
            ServerWorld serverWorld = (ServerWorld) ((ExperienceOrbEntity) (Object) this).world;
            XPTracker tracker = DifficultyPlusCardinal.WorldXP.get(serverWorld);
            tracker.addTotalXP(amount);
            DifficultyPlusCardinal.WorldXP.sync(serverWorld);
            for (World world:serverWorld.getServer().getWorlds()) {
                DifficultyPlusCardinal.WorldXP.get(world).setTotalXP(tracker.getTotalXP());
                DifficultyPlusCardinal.WorldXP.sync(world);
            }
        }
    }
}