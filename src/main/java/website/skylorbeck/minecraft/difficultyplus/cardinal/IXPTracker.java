package website.skylorbeck.minecraft.difficultyplus.cardinal;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;

public interface IXPTracker extends ComponentV3 {
    int getTotalXP();
    void addTotalXP(int i);
}
