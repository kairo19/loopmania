package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;

public class ZombiePitCard extends Card {
    public ZombiePitCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
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
