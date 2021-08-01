package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableArmour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;

/**
 * This class represents the armour defense item which reduces damage taken from enemies.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Armour extends DefensiveItem {
    private static final double DAMAGE_REDUCTION = 0.5;
    public Armour(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableArmour();
    } 
       

    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "Armour";
    }

}


