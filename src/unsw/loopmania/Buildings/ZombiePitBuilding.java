package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Zombie;

/**
 * This class represents the zombie pit building.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class ZombiePitBuilding extends Building{
    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Spawn zombie enemy at building location.
     * @param orderedPath - all path coords.
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
        return new Zombie(new PathPosition(indexInPath, orderedPath));
    }

    /**
     * Returns building name as string.
     */
    @Override
    public String toString() {
        return "ZombiePitBuilding";
    }
}
