package website.skylorbeck.minecraft.difficultyplus;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;


@Config(name = "difficultyplus")
public class ModConfig implements ConfigData {

    @Comment("150 = 1.5x Player multiplier")
    public int playerInfluence = 100; // 100 = 1 x player

    @Comment("This amount = 1% chance")
    public int xpRatio = 1000;//1000 == 0.01 == 1%

    @Comment("20 = 20% max chance")
    @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
    public int chanceCap = 100; //1==1%

    @Comment("Creepers, Spiders, Endermen, etc")
    public boolean allowNonArmorWearing = false;

    @Comment("Can be overpowered at high difficulty")
    public boolean allowDrops = true;

    @Comment("Determines what Status Effects can be used")
    @ConfigEntry.Gui.CollapsibleObject
    public StatusEffects statusEffects = new StatusEffects();

    @Comment("Determines what Armor Materials can be used")
    @ConfigEntry.Gui.CollapsibleObject
    public ArmorTiers armorTiers = new ArmorTiers();

    @Comment("Determines what Tool Materials can be used")
    @ConfigEntry.Gui.CollapsibleObject
    public Tiers tiers = new Tiers();

    @ConfigEntry.Gui.CollapsibleObject
    @Comment("Determines what Tools can be used")
    public Tools tools = new Tools();

    static class Tiers {
        boolean wood = true;
        boolean stone = false;
        boolean iron = true;
        boolean gold = false;
        boolean diamond = true;
        boolean netherite = false;
    }

    static class Tools {
        boolean sword = true;
        boolean pickaxe = false;
        boolean axe = true;
        boolean shovel = true;
        boolean hoe = false;
    }

    static class ArmorTiers {
        boolean leather = true;
        boolean chain = true;
        boolean iron = true;
        boolean gold = false;
        boolean diamond = true;
        boolean netherite = false;
    }

    static class StatusEffects {
        boolean regeneration = true;
        boolean speed = true;
        boolean fireResistance = true;
        boolean strength = true;
        boolean invisibility = true;
        boolean weakness = true;
        boolean slowness = true;
        boolean haste = false;
        boolean miningFatigue = false;
        boolean jumpBoost = false;
        boolean resistance = false;
        boolean waterBreathing = false;
        boolean nightVision = false;
        boolean hunger = false;
        boolean absorption = false;
        boolean glowing = false;
    }
}

