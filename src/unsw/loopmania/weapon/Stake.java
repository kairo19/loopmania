package unsw.loopmania.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Stake extends StaticEntity implements Weapon {
    private int damageBoost = 5;
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public int damageBoost(BasicEnemy basicEnemy) {
        int totalDamageBoost = damageBoost;
        if (basicEnemy.getType().equals("Vampire")) {
            totalDamageBoost *= 1.5;
        }
        return totalDamageBoost;
    }    
}
