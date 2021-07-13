package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.StaticEntity;

public class Helmet extends StaticEntity implements DefensiveItem {
    private double damageReduction = 10.0;
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public double damageReduction(BasicEnemy basicEnemy) {
        return damageReduction;
    }

    // damage reduction of character method here
}
