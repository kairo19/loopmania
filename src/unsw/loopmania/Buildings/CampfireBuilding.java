package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;


public class CampfireBuilding extends Building {

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(5);
    }
    /**
     * Doubles the attack damage of a character if they are in range
     * @param character 
     */
    public void DoubleAttack(Character character) {
        int damage = character.getDamage() * 2;
        character.setDamage(damage);
    }

    @Override
    public String toString() {
        return "CampfireBuilding";
    }
}