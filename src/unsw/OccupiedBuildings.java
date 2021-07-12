package unsw;
import org.javatuples.Pair;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;


public class OccupiedBuildings {

    private List<Pair<SimpleIntegerProperty, SimpleIntegerProperty>> buildingsInPath;

    public OccupiedBuildings() {
        this.buildingsInPath = null;
    }

    public void AddBuildings(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        buildingsInPath.add(new Pair<Integer, Integer>(x,y));
    }

    public boolean CheckBuildingExists(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        for (Pair<SimpleIntegerProperty, SimpleIntegerProperty> b:buildingsInPath) {
            if (b.equals(new Pair<SimpleIntegerProperty, SimpleIntegerProperty>(x,y))) {
                return true;
            }
        }
        return false;
    }
}
