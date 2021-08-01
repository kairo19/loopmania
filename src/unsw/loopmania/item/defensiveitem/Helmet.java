package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableHelmet;

/**
 * This class represents the helmet defensive item which reduces damage taken from enemies but debuffs character attack.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Helmet extends DefensiveItem implements Blinder {
    private static final double DAMAGE_REDUCTION = 5.0;
    private static final int DEBUFF_VALUE = 5;
    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableHelmet();
    }

    /**
     * Returns the integer reduction to character attack caused by the blinding debuff.
     */
    @Override
    public int debuff() {
        return DEBUFF_VALUE;
    }

    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Helmet";
    }

}
