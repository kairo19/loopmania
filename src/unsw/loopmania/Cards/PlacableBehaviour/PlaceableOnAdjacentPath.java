package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;
import org.javatuples.Pair;

/**
 * This class represents the placeable behaviour when placing on path-adjacent tiles.
 */

public class PlaceableOnAdjacentPath implements PlacableBehaviour {

    /**
     * Returns whether the item is placeable.
     * @param x - game world x coord position.
     * @param y - game world y coord position.
     * @param orderedPath - all path coordinates.
     */
    @Override
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath) {
        for (Pair<Integer, Integer> p: orderedPath) {
            if (p.getValue0() == x) {
                if ((y == p.getValue1() + 1) && !orderedPath.contains(new Pair<Integer, Integer>(p.getValue0(), p.getValue1() - 1))) {
                    return true;
                } else if ((y == p.getValue1() - 1) && !orderedPath.contains(new Pair<Integer, Integer>(p.getValue0(), p.getValue1() - 1))) {
                    return true;
                }
            } else if (p.getValue1() == y) {
                if ((x == p.getValue0() + 1) && !orderedPath.contains(new Pair<Integer, Integer>(p.getValue0() + 1, p.getValue1()))) {
                    return true;
                } else if ((x == p.getValue0() - 1) && !orderedPath.contains(new Pair<Integer, Integer>(p.getValue0() - 1, p.getValue1()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Implements logic for placing.
     * @param x - game world x coord position to place.
     * @param y - game world y coord position to place.
     */
    @Override
    public boolean itemPlacable(int x, int y) {
        return false;
    }
    
}
