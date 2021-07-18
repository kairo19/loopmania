package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;


public class CampfireBuilding extends Building {

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(3);
    }

    @Override
    public int CharacterBattleBuffAbility(Character character) {
        return character.getDamage();
    }

    @Override
    public String toString() {
        return "CampfireBuilding";
    }
}