package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends StaticEntity implements Weapon {
    private int damageBoost = 15;  
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public int damageBoost(BasicEnemy basicEnemy) {
        return damageBoost;
    }

    @Override
    public void doSpecial(BasicEnemy basicEnemy) {
        // do nothing - sword not special :(
    }

}
