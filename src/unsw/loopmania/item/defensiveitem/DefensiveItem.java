package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.StaticEntity;

public abstract class DefensiveItem extends StaticEntity {
    private double damageReduction;
    public DefensiveItem(SimpleIntegerProperty x, SimpleIntegerProperty y, double damageReduction) {
        super(x, y);
        this.damageReduction = damageReduction;
    }

    public double damageReduction() {
        return damageReduction;
    }
    
     
}
