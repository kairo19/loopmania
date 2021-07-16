package unsw.loopmania.Buildings;
import java.util.List;
import org.javatuples.Pair;


import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;

public abstract class Building extends StaticEntity {
    private int radius;
    //private PathPosition position;
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.radius = 0;
    }   
    
    public boolean checkInRange(PathPosition position) {
        int distance = this.radius;
        return true;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

}
