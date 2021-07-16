package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

public class VillageBuilding extends Building {
    public VillageBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public void RegainHealth(Character character) {
        int new_health = character.gethealth() + 20;
        character.sethealth(new_health);
    }
}
