package unsw.loopmania.Enemies;

import unsw.loopmania.Character;
import unsw.loopmania.PathPosition;

/**
 * This class represents a Elan Muske enemy.
 * @param pathPosition - enemy position on path.
 */

public class ElanMuske extends BasicEnemy implements SpecialAbility{
    public ElanMuske(PathPosition pathPosition) {
        // 2 battle radius, 2 support radius (nullifies since == to battle radius)
        super(pathPosition, 1000, 60, "ElanMuske", 1000, 500, 2, 2); // damage and health current placeholders
    }

    /**
     * Elan Muske deals damage to character.
     * @param character - character entity.  
     */
    @Override
    public void dealDamage(Character character) {
        super.dealDamage(character);
        doSpecial(character);

    }
    
    /**
     * Returns whether the enemy has a special attack.
     */
    @Override
    public boolean doSpecial(Character character) {
        return false;
    }

    /**
     * Returns whether the enemy is a boss.
     */
    @Override
    public boolean isBoss() {
        return true;
    }

    @Override
    public String toString() {
        return "ElanMuske";
    }
}
