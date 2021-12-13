package website.skylorbeck.minecraft.difficultyplus;

import net.fabricmc.tinyremapper.extension.mixin.common.Logger;

public class Declarar {
        public static Logger logger = new Logger(Logger.Level.INFO);

        public static float playerInfluence = 1f;
        public static float xpInfluence = 0.001f;
        public static float chanceCap = 1f;

}
