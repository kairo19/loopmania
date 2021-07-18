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
    private int BuildingAliveRounds = 0;
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        
    }
    /**
     * Counts the amount of rounds active since building spawned
     * @param round
     * @return
     */
    public int BuildingAlive(int round) {
        return round++;
    }

    public int getBuildingAliveRounds() {
        return BuildingAliveRounds;
    }
    /**
     * Spawns a vampire to the location of the building
     * @param world LoopManiaWorld
     * @return
     */
    @Override
    public BasicEnemy SpawnAbility(List<Pair<Integer, Integer>> orderedPath) {
        Pair<Integer, Integer> pos = new Pair<Integer,Integer>(super.getX(),super.getY());
        int indexInPath = orderedPath.indexOf(pos);
        return new Vampire(new PathPosition(indexInPath, orderedPath));
    }
    @Override
    public String toString() {
        return "VampireCastleBuilding";
    }
}
