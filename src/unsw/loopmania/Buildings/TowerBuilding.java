package unsw.loopmania.Buildings;
import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.BasicEnemy;

public class TowerBuilding extends Building {

    public TowerBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(5);
    }

    public void ShootEnemy(BasicEnemy Enemy) {
        
    }

    @Override
    public String toString() {
        return "TowerBuilding";
    }
}
