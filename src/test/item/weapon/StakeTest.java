package test.item.weapon;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.PathPosition;
import unsw.loopmania.item.weapon.Stake;
import unsw.loopmania.Character;

/*
public class StakeTest {
    @Test
    public void testStakeDamageBoost() {
        Character character = new Character(new PathPosition(0, null));
        // character.setDamage(0);
        Stake stake = new Stake(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        character.setWeapon(stake);
        assertEquals(5, character.getDamage()); 
    }

    @Test
    public void testStakeSpecial() {
        Character character = new Character(new PathPosition(0, null));
        // character.setDamage(5);
        Stake stake = new Stake(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        character.setWeapon(stake);
        Vampire vampire = new Vampire();
        character.dealsDamage(vampire); // should deal (5 + 5) * 1.5 damage 
        assertEquals(35, vampire.getHealth());
    }
}
*/