package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;
import org.javatuples.Pair;

/**
 * This class represents the helmet card placeable behaviour.
 */

public class PlacableHelmet implements PlacableBehaviour{

    /**
     * Returns whether the item is placeable.
     * @param x - card x coord position.
     * @param y - card y coord position.
     * @param orderedPath - all path coordinates.
     */
    @Override
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath) {
        return false;
    }

    /**
     * Implements logic for placing.
     * @param x - game world x coord position to place.
     * @param y - game world y coord position to place.
     */
    @Override
    public boolean itemPlacable(int x, int y) {
        if (x == 1 && y == 0) {
            return true;
        } else {
            return false;
        }
        
    }

}
