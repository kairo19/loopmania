package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.StaticEntity;

public class Helmet extends DefensiveItem implements Blinder {
    private static final double damageReduction = 10.0;
    private static final int debuffValue = 10;
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, damageReduction);
    }

    @Override
    public int debuff() {
        return debuffValue;
    }

}
