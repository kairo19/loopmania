package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.StaticEntity;

public class Helmet extends DefensiveItem implements Blinder {
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, 10.0);
    }

    @Override
    public int debuff() {
        return 10;
    }

}
