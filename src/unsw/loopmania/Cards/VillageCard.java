package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnNonPath;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnPath;

public class VillageCard extends Card {
    public VillageCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placable = new PlacableOnPath();
    }   
    @Override
    public String toString() {
        return "VillageCard";
    }

}
