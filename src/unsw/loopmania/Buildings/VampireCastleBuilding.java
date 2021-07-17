package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * a basic form of building in the world
 */
public class VampireCastleBuilding extends Building {
    // TODO = add more types of building, and make sure buildings have effects on entities as required by the spec
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public void SpawnVampire(int rounds) {

    }

    @Override
    public String toString() {
        return "VampireCastleBuilding";
    }
}
