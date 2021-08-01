package unsw.loopmania.item.consumable;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableHealthPotion;

/**
 * This class represents the potion consumable item which heals the character.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class HealthPotion extends Consumable {
    // private static final int HEAL = 20;
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableHealthPotion();
    }

    /**
     * Heals the character to full HP (100). 
     * @param character - character entity.
     */
    @Override
    public void consume(Character character) {
        if (character.getHealth()  > 100) {
            return;
        }
        character.setHealth(100);
    }    

    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "HealthPotion";
    }
}
