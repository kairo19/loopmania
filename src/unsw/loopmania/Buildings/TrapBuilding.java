package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;

public class TrapBuilding extends Building {
    
    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.setRadius(1);
    }
}
