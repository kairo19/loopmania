package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;

public class Building extends StaticEntity {
    private int radius;
    //private PathPosition position;
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.radius = 0;
    }   
    
    public boolean checkInRange(PathPosition position) {
        return true;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public boolean checkPosition(OccupiedBuildings occupied) {
        return occupied.CheckBuildingExists(getX(), getY());
    }

}
