package unsw.loopmania.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Staff extends StaticEntity implements Weapon {
    private int damageBoost = 2;
    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    

    @Override
    public int damageBoost(BasicEnemy basicEnemy) {
        return damageBoost;
    };

    // TODO: implement enemy conversion to ally
}
