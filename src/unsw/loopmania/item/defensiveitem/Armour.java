package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.StaticEntity;

public class Armour extends DefensiveItem {
    public Armour(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, 0.5);
    }    

}
