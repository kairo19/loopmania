package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.Cards.PlacableBehaviour.PlaceableOnAdjacentPath;

/**
 * This class represents the zombie pit building card.
 * @param x - building card x coord position.
 * @param y - building card y coord position.
 */

public class ZombiePitCard extends Card {
    public ZombiePitCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlaceableOnAdjacentPath();
    }       

    /**
     * Returns card name as string.
     */
    @Override
    public String toString() {
        return "ZombiePitCard";
    }
}
