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
    @ConfigEntry.BoundedDiscrete(min = 0,max = 100)
    public int chanceCap = 100; //1==1%

}

