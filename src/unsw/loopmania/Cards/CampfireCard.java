package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnNonPath;

/**
 * This class represents the campfire building card.
 * @param x - building card x coord position.
 * @param y - building card y coord position.
 */

public class CampfireCard extends Card {

    public CampfireCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableOnNonPath();
    }

    /**
     * Returns card name as string.
     */
    @Override
    public String toString() {
        return "CampfireCard";
    }
}
