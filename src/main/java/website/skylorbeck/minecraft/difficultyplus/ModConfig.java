package website.skylorbeck.minecraft.difficultyplus;

import website.skylorbeck.minecraft.skylorlib.MidnightConfig;


public class ModConfig extends MidnightConfig {
    @Entry
    public static int playerInfluence = 100; // 100 = 1 x player
    @Entry
    public static int xpRatio = 1000;//1000 == 0.01 == 1%

    @Entry(min = 0, max = 100)
    public static int chanceCap = 100; //1==1%

    @Entry
    public static boolean allowNonArmorWearing = false;

    @Entry
    public static
    boolean allowDrops = true;

    @Entry
    public static boolean leather = true;

    @Entry
    public static boolean chain = true;
    @Entry
    public static boolean wood = true;
    @Entry
    public static boolean stone = false;
    @Entry
    public static boolean iron = true;
    @Entry
    public static boolean gold = false;
    @Entry
    public static boolean diamond = true;
    @Entry
    public static boolean netherite = false;

    @Entry
    public static boolean sword = true;
    @Entry
    public static boolean pickaxe = false;
    @Entry
    public static boolean axe = true;
    @Entry
    public static boolean shovel = true;
    @Entry
    public static boolean hoe = false;



    @Entry
    public static boolean regeneration = true;
    @Entry
    public static boolean speed = true;
    @Entry
    public static boolean fireResistance = true;
    @Entry
    public static boolean strength = true;
    @Entry
    public static boolean invisibility = true;
    @Entry
    public static boolean weakness = true;
    @Entry
    public static boolean slowness = true;
    @Entry
    public static boolean haste = false;
    @Entry
    public static boolean miningFatigue = false;
    @Entry
    public static boolean jumpBoost = false;
    @Entry
    public static boolean resistance = false;
    @Entry
    public static boolean waterBreathing = false;
    @Entry
    public static boolean nightVision = false;
    @Entry
    public static boolean hunger = false;
    @Entry
    public static boolean absorption = false;
    @Entry
    public static boolean glowing = false;
}