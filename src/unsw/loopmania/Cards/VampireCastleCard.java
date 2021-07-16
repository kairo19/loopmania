package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;

/**
 * represents a vampire castle card in the backend game world
 */
public class VampireCastleCard extends Card {
    // TODO = add more types of card
    public VampireCastleCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    

    @Override
    public boolean CheckPathParam(List<Pair<Integer, Integer>> orderedPath) {
        if (!CheckOnPath(orderedPath) && CheckAdjacentPath(orderedPath)) {
            return true;
        }
        return false;
    }
}
