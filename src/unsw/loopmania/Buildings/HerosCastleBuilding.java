package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.ElanMuske;

import java.util.List;

import org.javatuples.Pair;

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
    
    public BasicEnemy SpawnDoggie(List<Pair<Integer, Integer>> orderedPath, Pair<Integer, Integer> position) {
            int indexInPath = orderedPath.indexOf(position);
            return new Doggie(new PathPosition(indexInPath, orderedPath));

    }

    public BasicEnemy SpawnElanMuske(List<Pair<Integer, Integer>> orderedPath, Pair<Integer, Integer> position) {
            int indexInPath = orderedPath.indexOf(position);
            return new ElanMuske(new PathPosition(indexInPath, orderedPath));
    }

    @Override
    public String toString() {
        return "HerosCastleBuilding";
    }

}
