package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;

/**
 * This class represents the village building.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class VillageBuilding extends Building {
    public VillageBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Applies village effect of healing character for 20 hp.
     * @param character - character entity.
     */
    @Override
    public void CharacterBuffAbility(Character character) {
        int new_health = character.getHealth() + 20;
        character.setHealth(new_health);
    }

    /**
     * Returns building name as string.
     */
    @Override
    public String toString() {
        return "VillageBuilding";
    }
}
