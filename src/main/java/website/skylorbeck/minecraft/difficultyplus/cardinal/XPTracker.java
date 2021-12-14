package website.skylorbeck.minecraft.difficultyplus.cardinal;

import net.minecraft.nbt.NbtCompound;

public class XPTracker implements IXPTracker {
    int TotalXPGained = 0;

    @Override
    public int getTotalXP() {
        return TotalXPGained;
    }

    @Override
    public void addTotalXP(int i) {
        TotalXPGained += i;
    }

    @Override
    public void setTotalXP(int i) {
        TotalXPGained = i;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        if (tag.contains("WorldXP")) {
            TotalXPGained = tag.getInt("WorldXP");
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putInt("WorldXP", TotalXPGained);
    }
}