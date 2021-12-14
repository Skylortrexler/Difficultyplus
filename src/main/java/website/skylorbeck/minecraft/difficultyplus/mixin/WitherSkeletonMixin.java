package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import website.skylorbeck.minecraft.difficultyplus.Declarar;
import website.skylorbeck.minecraft.difficultyplus.cardinal.DifficultyPlusCardinal;
import website.skylorbeck.minecraft.difficultyplus.cardinal.XPTracker;

@Mixin(WitherSkeletonEntity.class)
public class WitherSkeletonMixin {
    @Inject(method = "updateEnchantments", at = @At("RETURN"))
    private void checkDifficultSpawn(LocalDifficulty difficulty, CallbackInfo ci) {
        MobEntity mob = ((MobEntity) (Object) this);
        World world = mob.world;
        if (!world.isClient) {
            EntityType type = mob.getType();
            if (!type.getSpawnGroup().isPeaceful()) {
                XPTracker tracker = DifficultyPlusCardinal.WorldXP.get(world);
                float chance = MathHelper.clamp((tracker.getTotalXP() * Declarar.xpInfluence) * (world.getPlayers().size() * Declarar.playerInfluence), 0, Declarar.chanceCap);
                float random = world.random.nextFloat();
                if (random < chance) {

                    mob.addStatusEffect(new StatusEffectInstance(Declarar.statusEffects[world.random.nextInt(Declarar.statusEffects.length)], 9999, world.random.nextBoolean() ? 1 : 0));

                    random = world.random.nextFloat();
                    if (random < chance) {
                        if (!(mob instanceof SkeletonEntity))
                            mob.equipStack(EquipmentSlot.MAINHAND, Declarar.weapons[world.random.nextInt(Declarar.weapons.length)].getDefaultStack());
                    }
                    random = world.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.HEAD, Declarar.helmets[world.random.nextInt(Declarar.helmets.length)].getDefaultStack());

                    random = world.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.CHEST, Declarar.chests[world.random.nextInt(Declarar.chests.length)].getDefaultStack());

                    random = world.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.LEGS, Declarar.pants[world.random.nextInt(Declarar.pants.length)].getDefaultStack());

                    random = world.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.FEET, Declarar.boots[world.random.nextInt(Declarar.boots.length)].getDefaultStack());

                    for (ItemStack itemStack : mob.getItemsEquipped()) {
                        random = world.random.nextFloat();
                        if (random < chance)
                            EnchantmentHelper.enchant(world.random, itemStack, 1, true);
                    }
                    for (EquipmentSlot slot : EquipmentSlot.values()) {
                        mob.setEquipmentDropChance(slot, chance);
                    }
                }
            }
        }
    }
}
