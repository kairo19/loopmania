package unsw.loopmania.item.consumable;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;

/**
 * This class represents a consumable item.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public abstract class Consumable extends StaticEntity {
    public Consumable(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Abstract class for when using the consumable item.
     */
    public abstract void consume(Character character);

}
