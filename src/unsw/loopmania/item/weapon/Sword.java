package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends StaticEntity implements Weapon {
    private int damageBoost = 15;  
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public void damageBoost(Character character) {
        character.setDamage(character.getDamage() + damageBoost);
    }

    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        // do nothing - sword not special :(
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Sword";
    }
}
