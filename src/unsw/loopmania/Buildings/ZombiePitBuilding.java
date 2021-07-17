package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.Zombie;

public class ZombiePitBuilding extends Building{
    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public Zombie SpawnZombie(LoopManiaWorld world) {
        Pair<Integer, Integer> pos = new Pair<Integer,Integer>(super.getX(),super.getY());
        int indexInPath = world.getOrderedPath().indexOf(pos);
        return new Zombie(new PathPosition(indexInPath, world.getOrderedPath()));
    }

    @Override
    public String toString() {
        return "ZombiePitBuilding";
    }
}
