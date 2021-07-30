package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableShield;

public class TreeStump extends DefensiveItem {
    private static final double DAMAGE_REDUCTION = 20.0;
    public TreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableShield();
    }
    
    // @Override
    // public double damageReduction() { // may need to add basicenemy parameneter to check if boss
    //     if (isBoss) {
    //         return DAMAGE_REDUCTION * 3;
    //     }
    // }

    @Override
    public String toString() {
        return "TreeStump";
    }
}
