package website.skylorbeck.minecraft.difficultyplus.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import website.skylorbeck.minecraft.difficultyplus.Declarar;
import website.skylorbeck.minecraft.difficultyplus.cardinal.DifficultyPlusCardinal;
import website.skylorbeck.minecraft.difficultyplus.cardinal.XPTracker;

@Mixin(MobEntity.class)
public class SpawnHelperMixin {
    @Inject(method = "initialize", at = @At("RETURN"))
    private void checkDifficultSpawn(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, NbtCompound entityNbt, CallbackInfoReturnable<EntityData> cir) {
        MobEntity mob =  ((MobEntity)(Object)this);
        World mobWorld = mob.world;
        if (!mobWorld.isClient) {
            EntityType<?> type = mob.getType();
            if (!type.getSpawnGroup().isPeaceful()) {
                XPTracker tracker = DifficultyPlusCardinal.WorldXP.get(mobWorld);
                float chance = MathHelper.clamp((tracker.getTotalXP() * Declarar.xpInfluence) * (mobWorld.getPlayers().size() * Declarar.playerInfluence), 0, Declarar.chanceCap);
                float random = mobWorld.random.nextFloat();
                if (random < chance) {

                    mob.addStatusEffect(new StatusEffectInstance(Declarar.statusEffects[mobWorld.random.nextInt(Declarar.statusEffects.length)], 9999, mobWorld.random.nextBoolean() ? 1 : 0));

                    random = mobWorld.random.nextFloat();
                    if (random < chance) {
                        if (!(mob instanceof SkeletonEntity))
                        mob.equipStack(EquipmentSlot.MAINHAND, Declarar.weapons[mobWorld.random.nextInt(Declarar.weapons.length)].getDefaultStack());
                    }
                    random = mobWorld.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.HEAD, Declarar.helmets[mobWorld.random.nextInt(Declarar.helmets.length)].getDefaultStack());

                    random = mobWorld.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.CHEST, Declarar.chests[mobWorld.random.nextInt(Declarar.chests.length)].getDefaultStack());

                    random = mobWorld.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.LEGS, Declarar.pants[mobWorld.random.nextInt(Declarar.pants.length)].getDefaultStack());

                    random = mobWorld.random.nextFloat();
                    if (random < chance)
                        mob.equipStack(EquipmentSlot.FEET, Declarar.boots[mobWorld.random.nextInt(Declarar.boots.length)].getDefaultStack());

                    for (ItemStack itemStack : mob.getItemsEquipped()) {
                        random = mobWorld.random.nextFloat();
                        if (random < chance)
                            EnchantmentHelper.enchant(mobWorld.random, itemStack, 1, true);
                    }
                    for (EquipmentSlot slot : EquipmentSlot.values()) {
                        mob.setEquipmentDropChance(slot, chance);
                    }
                }
            }
        }
    }
}
