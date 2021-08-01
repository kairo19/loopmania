package unsw.loopmania.item.defensiveitem;

import unsw.loopmania.Enemies.BasicEnemy;

/**
 * Interface for blocking.
 */

public interface Block {
    public double damageReduction(BasicEnemy basicEnemy);
    public String toString();
    public double getDamageReduction();
}
