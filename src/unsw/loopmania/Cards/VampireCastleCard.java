package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.PathPosition;

/**
 * represents a vampire castle card in the backend game world
 */
public class VampireCastleCard extends Card {
    // TODO = add more types of card
    public VampireCastleCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }    

    @Override
    public boolean CheckPlacable(PathPosition position, int x, int y) {
        // TODO Auto-generated method stub
        return super.CheckPlacable(position, x, y);
    }
}
