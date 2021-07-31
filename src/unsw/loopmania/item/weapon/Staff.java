package unsw.loopmania.item.weapon;

import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;

/**
 * represents an equipped or unequipped staff in the backend world
 */
public class Staff extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 2;
    private int numTranced = 0;
    private boolean isTranced = false;

    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableWeapon();
        
    }    

    @Override
    public void damageBoost(Character character) {
        //character.setDamage(character.getDamage() + DAMAGE_BOOST);
        character.setBuffedDamage(DAMAGE_BOOST);
    };
    
    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        Random r = new Random();
        int i = r.nextInt(100);

        
        
        if (i < 10) { 
            isTranced = true;
            numTranced++;
        }
        
    };

    public void resetTrancedBool() {
        isTranced = false;
    }

    public boolean getTranchedBool() {
        return isTranced;
    }

    public int getTranched() {
        return numTranced;
    }

    public void resetTranced() {
        numTranced = 0;
    }

    public boolean checkItemplacable(int x, int y){
        
        return placableBehaviour.itemPlacable(x, y);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Staff";
    }
}
