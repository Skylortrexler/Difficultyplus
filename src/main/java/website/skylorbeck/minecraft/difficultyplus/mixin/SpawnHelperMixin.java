package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.Tag;
import net.minecraft.world.SpawnHelper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.minecraft.difficultyplus.Declarar;

@Mixin(SpawnHelper.class)
public class SpawnHelperMixin {

    @Shadow @Final private static Logger LOGGER;

    @Inject(method = "createMob", at = @At("RETURN"))
    private static void checkDifficultSpawn(ServerWorld world, EntityType<?> type, CallbackInfoReturnable<@Nullable MobEntity> cir) {
        if (!type.getSpawnGroup().isPeaceful()) {
            Declarar.logger.info("HOSTILESPAWN");
        }

    }
}
