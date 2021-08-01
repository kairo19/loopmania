package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;
import org.javatuples.Pair;

/**
 * This class represents the placeable behaviour when placing on non-path tiles.
 */

public class PlacableOnNonPath implements PlacableBehaviour{

    /**
     * Returns whether the item is placeable and indicates if placing attempt failed.
     * @param x - game world x coord position.
     * @param y - game world y coord position.
     * @param orderedPath - all path coordinates.
     */
    @Override
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath) {
        for (Pair<Integer,Integer> p: orderedPath) {
            if (p.getValue0() == x && p.getValue1() == y) {
                System.out.println("PlaceOnNONPATH FAILED");
                return false;
            }
        }
        return true;
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
