package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;

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
        character.setAllies(character.getAllies() + 1);
    }
    @Override
    public String toString() {
        
        return "BarracksBuilding";
    }

}

