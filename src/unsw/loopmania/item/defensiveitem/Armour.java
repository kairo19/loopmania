package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.StaticEntity;

public class Armour extends StaticEntity implements DefensiveItem {
    private double damageReduction  = 0.5;
    public Armour(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public double damageReduction(BasicEnemy basicEnemy) {
        // TODO Auto-generated method stub
        return damageReduction;
    }
    
}
