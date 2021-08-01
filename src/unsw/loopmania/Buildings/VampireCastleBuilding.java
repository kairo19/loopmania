package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Vampire;

/**
 * a basic form of building in the world
 */
public class VampireCastleBuilding extends Building {
    //private int buildingAliveRounds = 0;
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        
    }
    /**
     * Counts the amount of rounds active since building spawned
     * @param round
     * @return
     */
    /*
    public int getBuildingAliveRounds() {
        return buildingAliveRounds;
    }
    */
    /**
     * Spawns a vampire to the location of the building
     * @param world LoopManiaWorld
     * @return
     */
    @Override
    public BasicEnemy SpawnAbility(List<Pair<Integer, Integer>> orderedPath) {
        Pair<Integer, Integer> position = null;
        for (Pair<Integer, Integer> p: orderedPath) {
            if (p.getValue0() == super.getX()) {
                if ((p.getValue1() == super.getY() + 1) || (p.getValue1() == super.getY() - 1)) {
                    position = p;
                    break;
                }
            } else if (p.getValue1() == super.getY()) {
                if ((p.getValue0() == super.getX() + 1) || (p.getValue0() == super.getX() - 1)) {
                    position = p;
                    break;
                }
            }
    }
        int indexInPath = orderedPath.indexOf(position);
        return new Vampire(new PathPosition(indexInPath, orderedPath));
    }
    @Override
    public String toString() {
        return "VampireCastleBuilding";
    }
}
