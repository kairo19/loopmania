package unsw.loopmania;
import org.javatuples.Pair;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * This class represents a building occupied tile.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class OccupiedBuildings {

    private List<Pair<Integer, Integer>> buildingsInPath;

    public OccupiedBuildings() {
        this.buildingsInPath = null;
    }

    /**
     * Add building to occupied list.
     * @param x - building x coord position.
     * @param y - building y coord position.
     */
    public void AddBuildings(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        //buildingsInPath.add(new Pair<Integer, Integer>(x,y));
    }

    /**
     * Check if building exists at a position.
     * @param x - building x coord position.
     * @param y - building y coord position.
     */
    public boolean CheckBuildingExists(int x, int y) {
        for (Pair<Integer, Integer> b:buildingsInPath) {
            if (b.equals(new Pair<Integer, Integer>(x,y))) {
                return true;
            }
        }
        return false;
    }
}
