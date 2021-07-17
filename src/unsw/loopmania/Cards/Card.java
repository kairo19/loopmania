package unsw.loopmania.Cards;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {


    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public boolean checkPlacable(int x, int y, List<Pair<Integer, Integer>> orderedPath){
        return placableBehaviour.placable(x, y, orderedPath);
    }  

}
