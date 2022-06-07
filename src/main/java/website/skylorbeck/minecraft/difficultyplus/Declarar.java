package website.skylorbeck.minecraft.difficultyplus;

import net.fabricmc.tinyremapper.extension.mixin.common.Logger;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.entity.effect.StatusEffects.*;

public class Declarar {
        public static Logger logger = new Logger(Logger.Level.INFO);
        public static final String MODID = "difficultyplus";
        public static Identifier getIdentifier(String string){
                return new Identifier(MODID,string);
        }

        public static float playerInfluence = 1f;
        public static float xpInfluence = 0.00001f;
        public static float chanceCap = 1f;
        public static StatusEffect[] statusEffects = new StatusEffect[]{REGENERATION,SPEED,FIRE_RESISTANCE,STRENGTH,INVISIBILITY,WEAKNESS,SLOWNESS};//todo ModConfig
        public static Item[] helmets = new Item[]{Items.CHAINMAIL_HELMET,Items.LEATHER_HELMET,Items.IRON_HELMET,Items.DIAMOND_HELMET};
        public static Item[] chests = new Item[]{Items.CHAINMAIL_CHESTPLATE,Items.LEATHER_CHESTPLATE,Items.IRON_CHESTPLATE,Items.DIAMOND_CHESTPLATE};
        public static Item[] pants = new Item[]{Items.CHAINMAIL_LEGGINGS,Items.LEATHER_LEGGINGS,Items.IRON_LEGGINGS,Items.DIAMOND_LEGGINGS};
        public static Item[] boots = new Item[]{Items.CHAINMAIL_BOOTS,Items.LEATHER_BOOTS,Items.IRON_BOOTS,Items.DIAMOND_BOOTS};
        public static Item[] weapons = new Item[]{Items.WOODEN_AXE,Items.WOODEN_SHOVEL,Items.WOODEN_SWORD,Items.STONE_AXE,Items.STONE_SHOVEL,Items.STONE_SWORD,Items.IRON_AXE,Items.IRON_SHOVEL,Items.IRON_SWORD,Items.DIAMOND_AXE,Items.DIAMOND_SHOVEL,Items.DIAMOND_SWORD,};
        public static boolean allowNonArmor = false;
        public static boolean allowArmorDrop = true;
        public static EntityType<?>[] armorBanned = new EntityType[]{EntityType.VEX,EntityType.ZOGLIN,EntityType.HOGLIN,EntityType.PILLAGER,EntityType.ILLUSIONER,EntityType.EVOKER,EntityType.ENDERMAN,EntityType.CREEPER,EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.SPIDER,EntityType.ELDER_GUARDIAN,EntityType.GUARDIAN,EntityType.ENDER_DRAGON,EntityType.ENDERMITE,EntityType.GHAST,EntityType.MAGMA_CUBE,EntityType.PHANTOM,EntityType.SHULKER,EntityType.WITCH,EntityType.WITHER};
        public static void UpdateXPRates(){
                playerInfluence = ModConfig.playerInfluence*0.01f;
                xpInfluence = 0.01f/ModConfig.xpRatio;
                chanceCap = ModConfig.chanceCap*0.01f;
                allowNonArmor = ModConfig.allowNonArmorWearing;
                allowArmorDrop = ModConfig.allowDrops;

                //this gonna be ugly as fuck, sorry.

                List<StatusEffect> statusEffects = new ArrayList<>();
                List<Item> helmets = new ArrayList<>();
                List<Item> chests = new ArrayList<>();
                List<Item> pants = new ArrayList<>();
                List<Item> boots = new ArrayList<>();
                List<Item> weapons = new ArrayList<>();
                if (ModConfig.wood){
                        if (ModConfig.sword)
                                weapons.add(Items.WOODEN_SWORD);
                        if (ModConfig.pickaxe)
                                weapons.add(Items.WOODEN_PICKAXE);
                        if (ModConfig.axe)
                                weapons.add(Items.WOODEN_AXE);
                        if (ModConfig.shovel)
                                weapons.add(Items.WOODEN_SHOVEL);
                        if (ModConfig.hoe)
                                weapons.add(Items.WOODEN_HOE);
                }
                if (ModConfig.stone){
                        if (ModConfig.sword)
                                weapons.add(Items.STONE_SWORD);
                        if (ModConfig.pickaxe)
                                weapons.add(Items.STONE_PICKAXE);
                        if (ModConfig.axe)
                                weapons.add(Items.STONE_AXE);
                        if (ModConfig.shovel)
                                weapons.add(Items.STONE_SHOVEL);
                        if (ModConfig.hoe)
                                weapons.add(Items.STONE_HOE);
                }
                if (ModConfig.iron){
                        if (ModConfig.sword)
                                weapons.add(Items.IRON_SWORD);
                        if (ModConfig.pickaxe)
                                weapons.add(Items.IRON_PICKAXE);
                        if (ModConfig.axe)
                                weapons.add(Items.IRON_AXE);
                        if (ModConfig.shovel)
                                weapons.add(Items.IRON_SHOVEL);
                        if (ModConfig.hoe)
                                weapons.add(Items.IRON_HOE);
                }
                if (ModConfig.gold){
                        if (ModConfig.sword)
                                weapons.add(Items.GOLDEN_SWORD);
                        if (ModConfig.pickaxe)
                                weapons.add(Items.GOLDEN_PICKAXE);
                        if (ModConfig.axe)
                                weapons.add(Items.GOLDEN_AXE);
                        if (ModConfig.shovel)
                                weapons.add(Items.GOLDEN_SHOVEL);
                        if (ModConfig.hoe)
                                weapons.add(Items.GOLDEN_HOE);
                }
                if (ModConfig.diamond){
                        if (ModConfig.sword)
                                weapons.add(Items.DIAMOND_SWORD);
                        if (ModConfig.pickaxe)
                                weapons.add(Items.DIAMOND_PICKAXE);
                        if (ModConfig.axe)
                                weapons.add(Items.DIAMOND_AXE);
                        if (ModConfig.shovel)
                                weapons.add(Items.DIAMOND_SHOVEL);
                        if (ModConfig.hoe)
                                weapons.add(Items.DIAMOND_HOE);
                }
                if (ModConfig.netherite){
                        if (ModConfig.sword)
                                weapons.add(Items.NETHERITE_SWORD);
                        if (ModConfig.pickaxe)
                                weapons.add(Items.NETHERITE_PICKAXE);
                        if (ModConfig.axe)
                                weapons.add(Items.NETHERITE_AXE);
                        if (ModConfig.shovel)
                                weapons.add(Items.NETHERITE_SHOVEL);
                        if (ModConfig.hoe)
                                weapons.add(Items.NETHERITE_HOE);
                }
                if (weapons.size() == 0 )
                        weapons.add(Items.WOODEN_HOE);
                Declarar.weapons = weapons.toArray(new Item[]{});

                if (ModConfig.leather) {
                        helmets.add(Items.LEATHER_HELMET);
                        chests.add(Items.LEATHER_CHESTPLATE);
                        pants.add(Items.LEATHER_LEGGINGS);
                        boots.add(Items.LEATHER_BOOTS);
                }
                if (ModConfig.chain) {
                        helmets.add(Items.CHAINMAIL_HELMET);
                        chests.add(Items.CHAINMAIL_CHESTPLATE);
                        pants.add(Items.CHAINMAIL_LEGGINGS);
                        boots.add(Items.CHAINMAIL_BOOTS);
                }
                if (ModConfig.iron) {
                        helmets.add(Items.IRON_HELMET);
                        chests.add(Items.IRON_CHESTPLATE);
                        pants.add(Items.IRON_LEGGINGS);
                        boots.add(Items.IRON_BOOTS);
                }
                if (ModConfig.gold) {
                        helmets.add(Items.GOLDEN_HELMET);
                        chests.add(Items.GOLDEN_CHESTPLATE);
                        pants.add(Items.GOLDEN_LEGGINGS);
                        boots.add(Items.GOLDEN_BOOTS);
                }
                if (ModConfig.diamond) {
                        helmets.add(Items.DIAMOND_HELMET);
                        chests.add(Items.DIAMOND_CHESTPLATE);
                        pants.add(Items.DIAMOND_LEGGINGS);
                        boots.add(Items.DIAMOND_BOOTS);
                }
                if (ModConfig.netherite) {
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

                if (ModConfig.speed)
                        statusEffects.add(SPEED);
                if (ModConfig.absorption)
                        statusEffects.add(ABSORPTION);
                if (ModConfig.slowness)
                        statusEffects.add(SLOWNESS);
                if (ModConfig.haste)
                        statusEffects.add(HASTE);
                if (ModConfig.miningFatigue)
                        statusEffects.add(MINING_FATIGUE);
                if (ModConfig.regeneration)
                        statusEffects.add(REGENERATION);
                if (ModConfig.fireResistance)
                        statusEffects.add(FIRE_RESISTANCE);
                if (ModConfig.invisibility)
                        statusEffects.add(INVISIBILITY);
                if (ModConfig.strength)
                        statusEffects.add(STRENGTH);
                if (ModConfig.weakness)
                        statusEffects.add(WEAKNESS);
                if (ModConfig.resistance)
                        statusEffects.add(RESISTANCE);
                if (ModConfig.jumpBoost)
                        statusEffects.add(JUMP_BOOST);
                if (ModConfig.waterBreathing)
                        statusEffects.add(WATER_BREATHING);
                if (ModConfig.nightVision)
                        statusEffects.add(NIGHT_VISION);
                if (ModConfig.hunger)
                        statusEffects.add(HUNGER);
                if (ModConfig.glowing)
                        statusEffects.add(GLOWING);
                if (statusEffects.size() == 0 )
                        statusEffects.add(GLOWING);
                Declarar.statusEffects = statusEffects.toArray(new StatusEffect[]{});
        }
}