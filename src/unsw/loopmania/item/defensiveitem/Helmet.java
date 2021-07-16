package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.StaticEntity;

public class Helmet extends DefensiveItem implements Blinder {
    private static final double DAMAGE_REDUCTION = 10.0;
    private static final int DEBUFF_VALUE = 10;
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
    }

    @Override
    public int debuff() {
        return DEBUFF_VALUE;
    }

}
