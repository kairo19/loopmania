package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
public class VillageBuilding extends Building {
    public VillageBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }


    @Override
    public void CharacterBuffAbility(Character character) {
        int new_health = character.getHealth() + 20;
        character.setHealth(new_health);
    }

    @Override
    public String toString() {
        return "VillageBuilding";
    }
}
