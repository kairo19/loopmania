package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.ElanMuske;

import java.util.List;

import org.javatuples.Pair;

/**
 * This class represents the Hero's Castle building.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class HerosCastleBuilding extends Building {
    private int nextShopRound;
    private int counter;
    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.nextShopRound = 2;
        this.counter = 2;
    }  

    /**
     * Adds a cycle to the round variable after character loops the world
     * @param round - count of completed character completed rounds.
     */
    public int AddCycle(int round) {
        return round + 1;
    }
    
    /**
     * Returns true if the current round should provide the character with a shop
     * @param round - count of completed character completed rounds.
     */
    public boolean PurchaseCycle(int round) {
        if (nextShopRound == round) {
            nextShopRound = counter + round;
            counter++;
            return true; 
        }
        return false;
    }
    
    /**
     * Spawn doggie enemy at given position on path.
     * @param orderedPath - all path coords.
     * @param position - specific coord on path.
     */
    public BasicEnemy SpawnDoggie(List<Pair<Integer, Integer>> orderedPath, Pair<Integer, Integer> position) {
            int indexInPath = orderedPath.indexOf(position);
            return new Doggie(new PathPosition(indexInPath, orderedPath));

    }

    /**
     * Spawn Elan Musk enemy at given position on path.
     * @param orderedPath - all path coords.
     * @param position - specific coord on path.
     */
    public BasicEnemy SpawnElanMuske(List<Pair<Integer, Integer>> orderedPath, Pair<Integer, Integer> position) {
            int indexInPath = orderedPath.indexOf(position);
            return new ElanMuske(new PathPosition(indexInPath, orderedPath));
    }

    /**
     * Returns building name as string.
     */
    @Override
    public String toString() {
        return "HerosCastleBuilding";
    }

}
