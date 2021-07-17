package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnNonPath;

public class BarracksCard extends Card {

    public BarracksCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        placable = new PlacableOnNonPath();
    }  
    @Override
    public String toString() {
        return "BarracksCard";
    }
}
