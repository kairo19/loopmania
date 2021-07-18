package unsw.loopmania.Buildings;
import java.util.List;
import org.javatuples.Pair;


import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.BasicEnemy;

public abstract class Building extends StaticEntity implements SpecialBehaviour{
    private int radius;
    private int BuildingAliveRounds;
    //private PathPosition position;
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.radius = 0;
        this.BuildingAliveRounds = 0;
    }   
    
    public boolean checkInRange(int x, int y) {
        int distance = this.radius;
        return true;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getBuildingAliveRounds() {
        return BuildingAliveRounds;
    }

    public BasicEnemy SpawnAbility(List<Pair<Integer, Integer>> orderedPath) {
        return null;
    }
}
