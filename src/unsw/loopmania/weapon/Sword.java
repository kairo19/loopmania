package unsw.loopmania.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends StaticEntity implements Weapon {
    private int damageBoost;
    // TODO = add more weapon/item types
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.damageBoost = 15;
    }

    @Override
    public int damageBoost(BasicEnemy basicEnemy) {
        return damageBoost;
    }    
}
