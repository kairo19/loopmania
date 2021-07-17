package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 15;  
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public void damageBoost(Character character) {
        character.setDamage(character.getDamage() + DAMAGE_BOOST);
    }

    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        // do nothing - sword not special :(
    }
}
