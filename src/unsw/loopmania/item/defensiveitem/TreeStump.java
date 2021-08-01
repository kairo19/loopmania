package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableShield;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * This class represents the tree stump defensive item which reduces damage taken from enemies,
 * with a 3x multiplier to the reduction when facing boss enemies.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class TreeStump extends DefensiveItem implements Block {
    private static final double DAMAGE_REDUCTION = 20.0;
    public TreeStump(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableShield();
    }

    /**
     * Returns the damage reduction value, with 3x the reduction value when fighting a boss enemy.
     * @param basicEnemy - enemy entity.
     */
    @Override
    public double damageReduction(BasicEnemy basicEnemy) { // may need to add basicenemy parameneter to check if boss
        if (basicEnemy.isBoss()) {
             return DAMAGE_REDUCTION * 3;
        } else {
            return DAMAGE_REDUCTION;
        }
    }

    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "TreeStump";
    }
}
