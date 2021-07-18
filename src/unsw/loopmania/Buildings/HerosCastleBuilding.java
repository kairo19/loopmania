package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;

import java.util.List;

public class HerosCastleBuilding extends Building {
    private int counter;
    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.counter = 2;
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
    public boolean PurchaseCycle(int round) {
        if (counter == round && round != 1) {
            counter = counter + round;
            return true; 
        }
        return false;
    }
    

    @Override
    public String toString() {
        return "HerosCastleBuilding";
    }

}
