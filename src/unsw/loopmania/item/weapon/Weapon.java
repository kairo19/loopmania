package unsw.loopmania.item.weapon;

import unsw.loopmania.BasicEnemy;

public interface Weapon {
    public void damageBoost(Character character);
    public void doSpecial(BasicEnemy basicEnemy, Character character); // can be replaced with a gettype() method?
}
