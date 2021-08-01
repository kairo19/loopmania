package unsw.loopmania.item.defensiveitem;

import unsw.loopmania.Enemies.BasicEnemy;

public interface Block {
    public double damageReduction(BasicEnemy basicEnemy);
    public String toString();
}
