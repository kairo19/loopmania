package unsw.loopmania.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.PathPosition;

public class TowerCard extends Card {
    public TowerCard(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }   
    @Override
    public boolean CheckPlacable(PathPosition position, int x, int y) {
        // TODO Auto-generated method stub
        return super.CheckPlacable(position, x, y);
    }
}
