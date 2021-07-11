package unsw.loopmania.Buildings;

import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;

public class Building extends StaticEntity {
    private int radius;
    private PathPosition position;
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.radius = 0;
    }   
    
    public boolean checkInRange(PathPosition position) {

    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

}
