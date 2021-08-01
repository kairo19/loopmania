package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnPath;

/**
 * This class represents the village building card.
 * @param x - building card x coord position.
 * @param y - building card y coord position.
 */

public class VillageCard extends Card {
    public VillageCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableOnPath();
    }   

    /**
     * Returns card name as string.
     */
    @Override
    public String toString() {
        return "VillageCard";
    }

}
