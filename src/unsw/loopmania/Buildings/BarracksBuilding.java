package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;

/**
 * This class represents the barracks building.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class BarracksBuilding extends Building {

    public BarracksBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
    
    /**
     * Adds an extra ally to the character object
     * @param character
     */
    @Override
    public void CharacterBuffAbility(Character character) {
        character.gainAlly();
    }
    
    /**
     * Returns building name as string.
     */
    @Override
    public String toString() {
        
        return "BarracksBuilding";
    }

}

