package unsw.loopmania.Buildings;
import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

public class TrapBuilding extends Building {
    
    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.setRadius(1);
    }

    public void TrapEnemy(BasicEnemy Enemy) {
        int new_health = Enemy.getHealth() - 50;
        Enemy.setHealth(new_health);
    }
}
