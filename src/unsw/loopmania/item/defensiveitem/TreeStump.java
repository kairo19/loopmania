package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableShield;
import unsw.loopmania.Enemies.BasicEnemy;

public class TreeStump extends DefensiveItem implements Block {
    private static final double DAMAGE_REDUCTION = 20.0;
    public TreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableShield();
    }
    
    @Override
    public double damageReduction(BasicEnemy basicEnemy) { // may need to add basicenemy parameneter to check if boss
        if (basicEnemy.isBoss()) {
             return DAMAGE_REDUCTION * 3;
        } else {
            return DAMAGE_REDUCTION;
        }
    }

    @Override
    public String toString() {
        return "TreeStump";
    }
}
