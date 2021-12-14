package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.MathHelper;
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
import website.skylorbeck.minecraft.difficultyplus.cardinal.DifficultyPlusCardinal;
import website.skylorbeck.minecraft.difficultyplus.cardinal.XPTracker;

@Mixin(SpawnHelper.class)
public class SpawnHelperMixin {
    @Inject(method = "createMob", at = @At("RETURN"), cancellable = true)
    private static void checkDifficultSpawn(ServerWorld world, EntityType<?> type, CallbackInfoReturnable<@Nullable MobEntity> cir) {
        if (!type.getSpawnGroup().isPeaceful()) {
            XPTracker tracker = DifficultyPlusCardinal.WorldXP.get(world);
            float chance = MathHelper.clamp((tracker.getTotalXP()*Declarar.xpInfluence)* (world.getPlayers().size()*Declarar.playerInfluence),0,Declarar.chanceCap);
            float random= world.random.nextFloat();
//            Declarar.logger.info(random +" "+ chance);
            if (random<chance) {
                MobEntity entity = cir.getReturnValue();
                assert entity != null;

                entity.addStatusEffect(new StatusEffectInstance(Declarar.statusEffects[world.random.nextInt(Declarar.statusEffects.length)],9999,world.random.nextBoolean()?1:0));

                random = world.random.nextFloat();
                if (random<chance) {
                   //skeletons are initialized after this
                    entity.equipStack(EquipmentSlot.MAINHAND, Declarar.weapons[world.random.nextInt(Declarar.weapons.length)].getDefaultStack());
                }
                random = world.random.nextFloat();
                if (random<chance)
                    entity.equipStack(EquipmentSlot.HEAD,Declarar.helmets[world.random.nextInt(Declarar.helmets.length)].getDefaultStack());

                random = world.random.nextFloat();
                if (random<chance)
                    entity.equipStack(EquipmentSlot.CHEST,Declarar.chests[world.random.nextInt(Declarar.chests.length)].getDefaultStack());

                random = world.random.nextFloat();
                if (random<chance)
                    entity.equipStack(EquipmentSlot.LEGS,Declarar.pants[world.random.nextInt(Declarar.pants.length)].getDefaultStack());

                random = world.random.nextFloat();
                if (random<chance)
                    entity.equipStack(EquipmentSlot.FEET,Declarar.boots[world.random.nextInt(Declarar.boots.length)].getDefaultStack());

                for (ItemStack itemStack:entity.getItemsEquipped()) {
                    random = world.random.nextFloat();
                    if (random < chance)
                        EnchantmentHelper.enchant(world.random,itemStack,1,true);
                }
                for (EquipmentSlot slot:EquipmentSlot.values()) {
                    entity.setEquipmentDropChance(slot, chance);
                }
                cir.setReturnValue(entity);
//                Declarar.logger.info("mob Upgraded");
            }
        }

    }
}
