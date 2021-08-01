package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnPath;

/**
 * This class represents the barracks building card.
 * @param x - building card x coord position.
 * @param y - building card y coord position.
 */

public class BarracksCard extends Card {

    public BarracksCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        placableBehaviour = new PlacableOnPath();
    }  

    /**
     * Returns card name as string.
     */
    @Override
    public String toString() {
        return "BarracksCard";
    }
}
