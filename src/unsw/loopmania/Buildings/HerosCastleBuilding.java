package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;

import java.util.List;

public class HerosCastleBuilding extends Building {
    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }  

    /**
     * Adds a cycle to the round variable after character loops the world
     */
    public int AddCycle(int round) {
        return round + 1;
    }
    /**
     * Returns true if the current round should provide the character with a shop
     * @param Cycle
     * @return
     */
    public boolean PurchaseCycle(LoopManiaWorld world) {
        if (world.getRound() % 3 == 0) {
            return true;
        } else if (world.getRound() == 1) {
            return true;
        }
        return false;
    }
    
    public boolean ScaleStats(int Cycle) {
        if (Cycle % 10 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "HerosCastleBuilding";
    }

}
