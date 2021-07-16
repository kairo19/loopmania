package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Cards.PlacableBehaviour.PlaceableOnAdjacentPath;

public class TowerCard extends Card {
    public TowerCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placable = new PlaceableOnAdjacentPath();
    }   

}
