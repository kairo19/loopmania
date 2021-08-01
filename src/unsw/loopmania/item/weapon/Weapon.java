package unsw.loopmania.item.weapon;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;

/**
 * Interface for weapon items.
 */

public interface Weapon {
    public void damageBoost(Character character);
    public void doSpecial(BasicEnemy basicEnemy, Character character); // can be replaced with a gettype() method?
}
