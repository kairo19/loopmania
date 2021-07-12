package unsw.loopmania;
import org.javatuples.Pair;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;


public class OccupiedBuildings {

    private List<Pair<Integer, Integer>> buildingsInPath;

    public OccupiedBuildings() {
        this.buildingsInPath = null;
    }

    public void AddBuildings(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        //buildingsInPath.add(new Pair<Integer, Integer>(x,y));
    }

    public boolean CheckBuildingExists(int x, int y) {
        for (Pair<Integer, Integer> b:buildingsInPath) {
            if (b.equals(new Pair<Integer, Integer>(x,y))) {
                return true;
            }
        }
        return false;
    }
}
