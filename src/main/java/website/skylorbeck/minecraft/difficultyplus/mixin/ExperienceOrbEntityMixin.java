package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.minecraft.difficultyplus.Declarar;
import website.skylorbeck.minecraft.difficultyplus.ServerWorldAccessor;

@Mixin(ExperienceOrbEntity.class)
public class ExperienceOrbEntityMixin {

    @Shadow private int amount;

    @Inject(method = "onPlayerCollision", at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/player/PlayerEntity;addExperience(I)V"))
    private void logXPGains(PlayerEntity player, CallbackInfo ci) {
        if (!player.isCreative()) {
            Declarar.logger.info("XPgained"+amount);
            Declarar.logger.info(((ServerWorldAccessor)((ExperienceOrbEntity)(Object)this).world).getTotalXPGained()+" total XP before");
            ((ServerWorldAccessor)((ExperienceOrbEntity)(Object)this).world).addTotalXPGained(amount);
            Declarar.logger.info(((ServerWorldAccessor)((ExperienceOrbEntity)(Object)this).world).getChanceToUpgradeMob()+" Chance");
            Declarar.logger.info(((ServerWorldAccessor)((ExperienceOrbEntity)(Object)this).world).getTotalXPGained()+" total XP after");
        }
    }
}
