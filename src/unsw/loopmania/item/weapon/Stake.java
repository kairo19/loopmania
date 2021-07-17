package unsw.loopmania.item.weapon;

import java.lang.ProcessBuilder.Redirect.Type;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;

/**
 * represents an equipped or unequipped stake in the backend world
 */
public class Stake extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 5;
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public void damageBoost(Character character) {
        character.setDamage(character.getDamage() + DAMAGE_BOOST);
    }

    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        if (basicEnemy.getType().equals("Vampire")) {
            character.setDamage((int) (character.getDamage() * 1.5));
        }     
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Stake";
    }
}
