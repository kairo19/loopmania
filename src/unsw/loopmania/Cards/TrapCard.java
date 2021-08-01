package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnPath;

/**
 * This class represents the trap building card.
 * @param x - building card x coord position.
 * @param y - building card y coord position.
 */

public class TrapCard extends Card {
    public TrapCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableOnPath();
    }

    /**
     * Returns card name as string.
     */
    @Override
    public String toString() {
        return "TrapCard";
    }
}
