package unsw.loopmania.Cards;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * This abstract class represents a card, which represents a placable building entity.
 * @param x - building card x coord position.
 * @param y - building card y coord position.
 */

public abstract class Card extends StaticEntity {

    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Checks if a staticentity is placeable or not.
     * @param x - game world x position.
     * @param y - game world y position.
     * @param orderedPath - all path coords. 
     */
    public boolean checkPlacable(int x, int y, List<Pair<Integer, Integer>> orderedPath){
        return placableBehaviour.placable(x, y, orderedPath);
    }  

}
