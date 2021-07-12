package unsw.loopmania.Cards;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.StaticEntity;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {
    // TODO = implement other varieties of card than VampireCastleCard
    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public boolean CheckPosition(OccupiedBuildings occupied) {
        return occupied.CheckBuildingExists(getX(), getY());
    }
    public boolean CheckOnPath(List<Pair<Integer, Integer>> orderedPath) {
        return false;
    }

    public boolean CheckAdjacentPath(List<Pair<Integer, Integer>> orderedPath) {
        return false;
    }
    public boolean CheckPathParam() {
        return true;
    }
}
