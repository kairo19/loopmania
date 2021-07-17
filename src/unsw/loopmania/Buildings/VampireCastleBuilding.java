package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.Vampire;

/**
 * a basic form of building in the world
 */
public class VampireCastleBuilding extends Building {
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        
    }
    /**
     * Spawns a vampire to the location of the building
     * @param world LoopManiaWorld
     * @return
     */
    public Vampire SpawnVampire(LoopManiaWorld world) {
        Pair<Integer, Integer> pos = new Pair<Integer,Integer>(super.getX(),super.getY());
        int indexInPath = world.getOrderedPath().indexOf(pos);
        return new Vampire(new PathPosition(indexInPath, world.getOrderedPath()));
    }

    @Override
    public String toString() {
        return "VampireCastleBuilding";
    }
}
