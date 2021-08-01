package unsw.loopmania.item.weapon;

import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;

/**
 * This class represents the staff weapon item which boosts attack by 2 damage.
 * The special attack of this weapon deals has a chance of applying trance to enemies, which
 * temporarily converts an enemy to an ally for a battle.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Staff extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 2;
    private int numTranced = 0;
    private boolean isTranced = false;

    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableWeapon();
        
    }    

    /**
     * Applies damage boost to character.
     * @param character - character entity.
     */
    @Override
    public void damageBoost(Character character) {
        character.setBuffedDamage(DAMAGE_BOOST);
    };
    
    /**
     * Applies item special attack to an enemy.
     * @param character - character entity.
     * @param basicEnemy - enemy entity.
     */
    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        Random r = new Random();
        int i = r.nextInt(100);

        
        
        if (i < 10) { 
            isTranced = true;
            numTranced++;
        }
        
    };

    /**
     * De-activates staff trance state.
     */
    public void resetTrancedBool() {
        isTranced = false;
    }

    /**
     * Returns whether trance state is activated.
     */
    public boolean getTranchedBool() {
        return isTranced;
    }

    public int getTranched() {
        return numTranced;
    }

    /**
     * Resets counter for number of tranced turns to 0.
     */
    public void resetTranced() {
        numTranced = 0;
    }

    /**
     * Checks whether item is placable.
     */
    public boolean checkItemplacable(int x, int y){
        
        return placableBehaviour.itemPlacable(x, y);
    }
    
    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "Staff";
    }
}
