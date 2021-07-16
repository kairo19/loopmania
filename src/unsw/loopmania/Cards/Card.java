package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {
    PlacableBehaviour placable;

    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public void setPlacable(PlacableBehaviour placable) {
        this.placable = placable;
    }

    public boolean CheckPosition(OccupiedBuildings occupied) {
        return occupied.CheckBuildingExists(getX(), getY());
    }
}
