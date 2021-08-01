package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

/**
 * This class represents a zombie enemy.
 * @param pathPosition - enemy position on path.
 */

public class Zombie extends BasicEnemy implements SpecialAbility {
    public Zombie(PathPosition pathPosition) {
        // 2 battle radius, 2 support radius (nullifies since == to battle radius)
        super(pathPosition, 25, 10, "Zombie", 20, 20, 2, 2);
    }

    /**
     * Zombie deals damage to character.
     * @param character - character entity.  
     */
    @Override
    public void dealDamage(Character character) {
        super.dealDamage(character);

    }

    /**
     * Zombie special attack which kills a character ally.
     * @param character - character entity.  
     */
    @Override
    public boolean doSpecial(Character character) {
        Random r = new Random();
        int chance = r.nextInt(100);
        if (chance < 50) {
            System.out.println("CHANCE HIT");
            if (character.getAlly() > 0) 
                character.loseAlly();
                return true;
            
        }

        return false;
    }

    /**
     * Returns enemy name as string.
     */
    @Override
    public String toString() {
        return "Zombie";
    }
}

