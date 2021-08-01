package unsw.loopmania.Enemies;


import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

/**
 * This class represents a doggie enemy.
 * @param pathPosition - enemy position on path.
 */

public class Doggie extends BasicEnemy implements SpecialAbility{
    public Doggie(PathPosition pathPosition) {
        super(pathPosition, 100, 40, "Doggie", 1000, 250, 2, 2); 
    }

    /**
     * Doggie deals damage to character.
     * @param character - character entity.  
     */
    @Override
    public void dealDamage(Character character) {
        super.dealDamage(character);
        doSpecial(character);

    }

    /**
     * Doggie special attack which stuns character
     * Skips characters attack and Enemy attacks twice.
     * @param character - character entity.  
     */
    @Override
    public boolean doSpecial(Character character) {
        boolean check = false;
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 10){
            System.out.println("CHARACTER STUNNED!!");
            check = true;
            dealDamage(character);
        }

        return check;

    }

    /**
     * Returns whether the enemy is a boss.
     */
    @Override
    public boolean isBoss() {
        return true;
    }
}
