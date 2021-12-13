package website.skylorbeck.minecraft.difficultyplus;

import net.fabricmc.tinyremapper.extension.mixin.common.Logger;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

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
        public static StatusEffect[] statusEffects = new StatusEffect[]{REGENERATION,SPEED,FIRE_RESISTANCE,STRENGTH,INVISIBILITY,WEAKNESS,SLOWNESS};
        public static Item[] helmets = new Item[]{Items.CHAINMAIL_HELMET,Items.LEATHER_HELMET,Items.IRON_HELMET,Items.DIAMOND_HELMET};
        public static Item[] chests = new Item[]{Items.CHAINMAIL_CHESTPLATE,Items.LEATHER_CHESTPLATE,Items.IRON_CHESTPLATE,Items.DIAMOND_CHESTPLATE};
        public static Item[] pants = new Item[]{Items.CHAINMAIL_LEGGINGS,Items.LEATHER_LEGGINGS,Items.IRON_LEGGINGS,Items.DIAMOND_LEGGINGS};
        public static Item[] boots = new Item[]{Items.CHAINMAIL_BOOTS,Items.LEATHER_BOOTS,Items.IRON_BOOTS,Items.DIAMOND_BOOTS};
        public static Item[] weapons = new Item[]{Items.WOODEN_AXE,Items.WOODEN_SHOVEL,Items.WOODEN_SWORD,Items.IRON_AXE,Items.IRON_SHOVEL,Items.IRON_SWORD,Items.DIAMOND_AXE,Items.DIAMOND_SHOVEL,Items.DIAMOND_SWORD,};
}
