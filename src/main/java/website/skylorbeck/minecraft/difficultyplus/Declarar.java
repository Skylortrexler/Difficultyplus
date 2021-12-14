package website.skylorbeck.minecraft.difficultyplus;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.tinyremapper.extension.mixin.common.Logger;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


import java.util.ArrayList;
import java.util.List;

import static net.minecraft.entity.effect.StatusEffects.*;

public class Declarar {
        public static Logger logger = new Logger(Logger.Level.INFO);
        public static final String MODID = "difficultyplus";
        public static Identifier getIdentifier(String string){
                return new Identifier(MODID,string);
        }
        public static ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        public static float playerInfluence = 1f;
        public static float xpInfluence = 0.00001f;
        public static float chanceCap = 1f;
        public static StatusEffect[] statusEffects = new StatusEffect[]{REGENERATION,SPEED,FIRE_RESISTANCE,STRENGTH,INVISIBILITY,WEAKNESS,SLOWNESS};//todo config
        public static Item[] helmets = new Item[]{Items.CHAINMAIL_HELMET,Items.LEATHER_HELMET,Items.IRON_HELMET,Items.DIAMOND_HELMET};
        public static Item[] chests = new Item[]{Items.CHAINMAIL_CHESTPLATE,Items.LEATHER_CHESTPLATE,Items.IRON_CHESTPLATE,Items.DIAMOND_CHESTPLATE};
        public static Item[] pants = new Item[]{Items.CHAINMAIL_LEGGINGS,Items.LEATHER_LEGGINGS,Items.IRON_LEGGINGS,Items.DIAMOND_LEGGINGS};
        public static Item[] boots = new Item[]{Items.CHAINMAIL_BOOTS,Items.LEATHER_BOOTS,Items.IRON_BOOTS,Items.DIAMOND_BOOTS};
        public static Item[] weapons = new Item[]{Items.WOODEN_AXE,Items.WOODEN_SHOVEL,Items.WOODEN_SWORD,Items.STONE_AXE,Items.STONE_SHOVEL,Items.STONE_SWORD,Items.IRON_AXE,Items.IRON_SHOVEL,Items.IRON_SWORD,Items.DIAMOND_AXE,Items.DIAMOND_SHOVEL,Items.DIAMOND_SWORD,};
        public static boolean allowNonArmor = false;
        public static EntityType<?>[] armorBanned = new EntityType[]{EntityType.VEX,EntityType.ZOGLIN,EntityType.HOGLIN,EntityType.PILLAGER,EntityType.ILLUSIONER,EntityType.EVOKER,EntityType.ENDERMAN,EntityType.CREEPER,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.SPIDER,EntityType.ELDER_GUARDIAN,EntityType.GUARDIAN,EntityType.ENDER_DRAGON,EntityType.ENDERMITE,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PHANTOM,EntityType.SHULKER,EntityType.WITCH,EntityType.WITHER};
        public static void UpdateXPRates(){
                playerInfluence = config.playerInfluence*0.01f;
                xpInfluence = 0.01f/config.xpRatio;
                chanceCap = config.chanceCap*0.01f;
                allowNonArmor = config.allowNonArmorWearing;
                //this gonna be ugly as fuck, sorry.

                List<StatusEffect> statusEffects = new ArrayList<>();
                List<Item> helmets = new ArrayList<>();
                List<Item> chests = new ArrayList<>();
                List<Item> pants = new ArrayList<>();
                List<Item> boots = new ArrayList<>();
                List<Item> weapons = new ArrayList<>();
                if (config.tiers.wood){
                        if (config.tools.sword)
                                weapons.add(Items.WOODEN_SWORD);
                        if (config.tools.pickaxe)
                                weapons.add(Items.WOODEN_PICKAXE);
                        if (config.tools.axe)
                                weapons.add(Items.WOODEN_AXE);
                        if (config.tools.shovel)
                                weapons.add(Items.WOODEN_SHOVEL);
                        if (config.tools.hoe)
                                weapons.add(Items.WOODEN_HOE);
                }
                if (config.tiers.stone){
                        if (config.tools.sword)
                                weapons.add(Items.STONE_SWORD);
                        if (config.tools.pickaxe)
                                weapons.add(Items.STONE_PICKAXE);
                        if (config.tools.axe)
                                weapons.add(Items.STONE_AXE);
                        if (config.tools.shovel)
                                weapons.add(Items.STONE_SHOVEL);
                        if (config.tools.hoe)
                                weapons.add(Items.STONE_HOE);
                }
                if (config.tiers.iron){
                        if (config.tools.sword)
                                weapons.add(Items.IRON_SWORD);
                        if (config.tools.pickaxe)
                                weapons.add(Items.IRON_PICKAXE);
                        if (config.tools.axe)
                                weapons.add(Items.IRON_AXE);
                        if (config.tools.shovel)
                                weapons.add(Items.IRON_SHOVEL);
                        if (config.tools.hoe)
                                weapons.add(Items.IRON_HOE);
                }
                if (config.tiers.gold){
                        if (config.tools.sword)
                                weapons.add(Items.GOLDEN_SWORD);
                        if (config.tools.pickaxe)
                                weapons.add(Items.GOLDEN_PICKAXE);
                        if (config.tools.axe)
                                weapons.add(Items.GOLDEN_AXE);
                        if (config.tools.shovel)
                                weapons.add(Items.GOLDEN_SHOVEL);
                        if (config.tools.hoe)
                                weapons.add(Items.GOLDEN_HOE);
                }
                if (config.tiers.diamond){
                        if (config.tools.sword)
                                weapons.add(Items.DIAMOND_SWORD);
                        if (config.tools.pickaxe)
                                weapons.add(Items.DIAMOND_PICKAXE);
                        if (config.tools.axe)
                                weapons.add(Items.DIAMOND_AXE);
                        if (config.tools.shovel)
                                weapons.add(Items.DIAMOND_SHOVEL);
                        if (config.tools.hoe)
                                weapons.add(Items.DIAMOND_HOE);
                }
                if (config.tiers.netherite){
                        if (config.tools.sword)
                                weapons.add(Items.NETHERITE_SWORD);
                        if (config.tools.pickaxe)
                                weapons.add(Items.NETHERITE_PICKAXE);
                        if (config.tools.axe)
                                weapons.add(Items.NETHERITE_AXE);
                        if (config.tools.shovel)
                                weapons.add(Items.NETHERITE_SHOVEL);
                        if (config.tools.hoe)
                                weapons.add(Items.NETHERITE_HOE);
                }
                if (weapons.size() == 0 )
                        weapons.add(Items.WOODEN_HOE);
                Declarar.weapons = weapons.toArray(new Item[]{});

                if (config.armorTiers.leather) {
                        helmets.add(Items.LEATHER_HELMET);
                        chests.add(Items.LEATHER_CHESTPLATE);
                        pants.add(Items.LEATHER_LEGGINGS);
                        boots.add(Items.LEATHER_BOOTS);
                }
                if (config.armorTiers.chain) {
                        helmets.add(Items.CHAINMAIL_HELMET);
                        chests.add(Items.CHAINMAIL_CHESTPLATE);
                        pants.add(Items.CHAINMAIL_LEGGINGS);
                        boots.add(Items.CHAINMAIL_BOOTS);
                }
                if (config.armorTiers.iron) {
                        helmets.add(Items.IRON_HELMET);
                        chests.add(Items.IRON_CHESTPLATE);
                        pants.add(Items.IRON_LEGGINGS);
                        boots.add(Items.IRON_BOOTS);
                }
                if (config.armorTiers.gold) {
                        helmets.add(Items.GOLDEN_HELMET);
                        chests.add(Items.GOLDEN_CHESTPLATE);
                        pants.add(Items.GOLDEN_LEGGINGS);
                        boots.add(Items.GOLDEN_BOOTS);
                }
                if (config.armorTiers.diamond) {
                        helmets.add(Items.DIAMOND_HELMET);
                        chests.add(Items.DIAMOND_CHESTPLATE);
                        pants.add(Items.DIAMOND_LEGGINGS);
                        boots.add(Items.DIAMOND_BOOTS);
                }
                if (config.armorTiers.netherite) {
                        helmets.add(Items.NETHERITE_HELMET);
                        chests.add(Items.NETHERITE_CHESTPLATE);
                        pants.add(Items.NETHERITE_LEGGINGS);
                        boots.add(Items.NETHERITE_BOOTS);
                }

                if (helmets.size() == 0 )
                        helmets.add(Items.LEATHER_HELMET);
                if (chests.size() == 0 )
                        chests.add(Items.LEATHER_CHESTPLATE);
                if (pants.size() == 0 )
                        pants.add(Items.LEATHER_LEGGINGS);
                if (boots.size() == 0 )
                        boots.add(Items.LEATHER_BOOTS);
                Declarar.helmets = helmets.toArray(new Item[]{});
                Declarar.chests = chests.toArray(new Item[]{});
                Declarar.pants = pants.toArray(new Item[]{});
                Declarar.boots = boots.toArray(new Item[]{});

                if (config.statusEffects.speed)
                        statusEffects.add(SPEED);
                if (config.statusEffects.absorption)
                        statusEffects.add(ABSORPTION);
                if (config.statusEffects.slowness)
                        statusEffects.add(SLOWNESS);
                if (config.statusEffects.haste)
                        statusEffects.add(HASTE);
                if (config.statusEffects.miningFatigue)
                        statusEffects.add(MINING_FATIGUE);
                if (config.statusEffects.regeneration)
                        statusEffects.add(REGENERATION);
                if (config.statusEffects.fireResistance)
                        statusEffects.add(FIRE_RESISTANCE);
                if (config.statusEffects.invisibility)
                        statusEffects.add(INVISIBILITY);
                if (config.statusEffects.strength)
                        statusEffects.add(STRENGTH);
                if (config.statusEffects.weakness)
                        statusEffects.add(WEAKNESS);
                if (config.statusEffects.resistance)
                        statusEffects.add(RESISTANCE);
                if (config.statusEffects.jumpBoost)
                        statusEffects.add(JUMP_BOOST);
                if (config.statusEffects.waterBreathing)
                        statusEffects.add(WATER_BREATHING);
                if (config.statusEffects.nightVision)
                        statusEffects.add(NIGHT_VISION);
                if (config.statusEffects.hunger)
                        statusEffects.add(HUNGER);
                if (config.statusEffects.glowing)
                        statusEffects.add(GLOWING);
                if (statusEffects.size() == 0 )
                        statusEffects.add(GLOWING);
                Declarar.statusEffects = statusEffects.toArray(new StatusEffect[]{});
        }
}