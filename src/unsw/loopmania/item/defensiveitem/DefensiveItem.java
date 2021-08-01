package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.StaticEntity;

/**
 * This class represents a defensive item that reduces damage taken from enemies by a specified multiplier.
 * @param x - item x coord position.
 * @param y - item y coord position.
 * @param damageReduction - decimal representation of percentage reduction in damage taken from enemies.
 */

public abstract class DefensiveItem extends StaticEntity {
    private double damageReduction;
    public DefensiveItem(SimpleIntegerProperty x, SimpleIntegerProperty y, double damageReduction) {
        super(x, y);
        this.damageReduction = damageReduction;
    }

    public double damageReduction(BasicEnemy basicEnemy) {
        return damageReduction;
    }
    
    public double getDamageReduction() {
        return damageReduction;
    }
     
}
