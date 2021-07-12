package unsw.loopmania.item.weapon;

import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped staff in the backend world
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
    
    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        Random r = new Random();
        int i = r.nextInt(100);
        if (i < 10) { 
            // convert enemy to ally
            // character.gainAlly();
            // basicEnemy.setTranced();
        }
    };
}
