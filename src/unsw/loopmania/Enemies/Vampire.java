package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

/**
 * This class represents a vampire enemy.
 * @param pathPosition - enemy position on path.
 */

public class Vampire extends BasicEnemy implements SpecialAbility {

    private boolean crit;
    private int counter;
    private Random r;
    private int maxCrit;


    public Vampire(PathPosition pathPosition) {
        super(pathPosition, 50, 20, "Vampire", 30, 20, 3, 5);
        crit = false;
        r = new Random();
        maxCrit = r.nextInt(5) + 1;

    }

    /**
     * Vampire deals damage to character.
     * @param character - character entity.
     */
    @Override
    public void dealDamage(Character character) {
        
        super.dealDamage(character);
        doSpecial(character);
    }

    /**
     * Determines whether the vampire does a special attack.
     * @param character - character entity.  
     */
    @Override
    public boolean doSpecial(Character character) {
        Random r = new Random();
        int chance = r.nextInt(100);
        if (chance < 10) {
            
            crit = true;
            return true;
            
        }

        return false;
    }

    /**
     * Calculates critical damage from vampire special attack.
     * @param character - character entity. 
     */
    @Override
    public boolean critDamage(Character character) {
        
    
        if (crit) {
            if (counter >= maxCrit) {
                counter = 0;
                crit = false;
                maxCrit = r.nextInt(5) + 1;
                return false;
            }
            counter ++;
            return true;
        }

        return false;
    }

    /**
     * Returns enemy name as string.
     */
    @Override
    public String toString() {
        return "Vampire";
    }
}
