package unsw.loopmania.item.defensiveitem;

import unsw.loopmania.StaticEntity;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.StaticEntity;

public class Shield extends StaticEntity implements DefensiveItem {
    private double damageReduction = 20.0;  
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public double damageReduction(BasicEnemy basicEnemy) {
        return damageReduction;
    }
    
    // lowerCriticalDamage method here
}
