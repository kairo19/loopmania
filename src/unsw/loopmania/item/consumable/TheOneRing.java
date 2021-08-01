package unsw.loopmania.item.consumable;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;

/**
 * This class represents the one ring consumable item which heals the player to full HP and has multiple uses.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class TheOneRing extends Consumable {
    private static final int FULL_HEALTH = 100;
    public TheOneRing(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Heals character to full HP (100).
     */
    @Override
    public void consume(Character character) {
        character.setHealth(FULL_HEALTH);        
    }

    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "TheOneRing";
    }
}
