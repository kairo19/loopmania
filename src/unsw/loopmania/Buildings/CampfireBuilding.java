package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;


public class CampfireBuilding extends Building {

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(5);
    }

    public void DoubleAttack(Character character) {
        int damage = character.getDamage() * 2;
        character.setDamage(damage);
    }
    
}