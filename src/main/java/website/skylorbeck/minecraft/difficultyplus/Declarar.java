package website.skylorbeck.minecraft.difficultyplus;

import net.fabricmc.tinyremapper.extension.mixin.common.Logger;
import net.minecraft.util.Identifier;

public class Declarar {
        public static Logger logger = new Logger(Logger.Level.INFO);
        public static final String MODID = "difficultyplus";
        public static Identifier getIdentifier(String string){
                return new Identifier(MODID,string);
        }
        public static float playerInfluence = 1f;
        public static float xpInfluence = 0.001f;
        public static float chanceCap = 1f;

}
