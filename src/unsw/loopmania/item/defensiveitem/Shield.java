package unsw.loopmania.item.defensiveitem;

import unsw.loopmania.StaticEntity;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableShield;

/**
 * This class represents the shield defensive item which reduces damage taken from enemies.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Shield extends DefensiveItem implements Block{
    private static final double DAMAGE_REDUCTION = 10.0;  
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableShield();
    }
    
    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "Shield";
    }
}
