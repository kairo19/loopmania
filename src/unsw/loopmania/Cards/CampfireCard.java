package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnNonPath;

public class CampfireCard extends Card {

    public CampfireCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placable = new PlacableOnNonPath();
    }   
}
