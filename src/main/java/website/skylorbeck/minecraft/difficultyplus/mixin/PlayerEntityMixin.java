package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.minecraft.difficultyplus.cardinal.DifficultyPlusCardinal;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "getXpToDrop", at = @At("RETURN"))
    public void levelWorldDown(PlayerEntity player, CallbackInfoReturnable<Integer> cir){
        if (cir.getReturnValue()>0) {
            DifficultyPlusCardinal.WorldXP.get(((PlayerEntity)(Object)this).world).addTotalXP(-cir.getReturnValue());
        }
    }
}
