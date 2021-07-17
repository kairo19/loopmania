package unsw.loopmania.item.defensiveitem;

import unsw.loopmania.StaticEntity;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;

public class Shield extends DefensiveItem {
    private static final double damageReduction = 20.0;  
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, damageReduction);
    }
    
    // lowerCriticalDamage method here
}
