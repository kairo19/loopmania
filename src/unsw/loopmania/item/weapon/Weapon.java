package unsw.loopmania.item.weapon;

public interface Weapon {
    // TODO: BasicEnemy requires implementation
    public int damageBoost(BasicEnemy basicEnemy);
    public void doSpecial(BasicEnemy basicEnemy, Character character); // can be replaced with a gettype() method?
}
