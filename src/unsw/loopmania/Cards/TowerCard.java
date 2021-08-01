package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Cards.PlacableBehaviour.PlaceableOnAdjacentPath;

/**
 * This class represents the tower building card.
 * @param x - building card x coord position.
 * @param y - building card y coord position.
 */

public class TowerCard extends Card {
    public TowerCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlaceableOnAdjacentPath();
    } 

    /**
     * Returns card name as string.
     */
    @Override
    public String toString() {
        return "TowerCard";
    }
}
