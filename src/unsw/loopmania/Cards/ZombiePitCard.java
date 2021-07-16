package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.Cards.PlacableBehaviour.PlaceableOnAdjacentPath;

public class ZombiePitCard extends Card {
    public ZombiePitCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placable = new PlaceableOnAdjacentPath();
    }       
}
