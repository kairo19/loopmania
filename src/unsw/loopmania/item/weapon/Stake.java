package unsw.loopmania.item.weapon;

import java.lang.ProcessBuilder.Redirect.Type;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped stake in the backend world
 */
public class Stake extends StaticEntity implements Weapon {
    private int damageBoost = 5;
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public int damageBoost(BasicEnemy basicEnemy) {
        return damageBoost;
    }

    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        if (basicEnemy.getType().equals("Vampire")) {
            character.setDamage(character.getDamage() * 1.5);
        }     
    }
}
