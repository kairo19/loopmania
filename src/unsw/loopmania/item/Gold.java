package unsw.loopmania.item;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnPath;

/**
 * This class represents the gold item.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Gold extends StaticEntity{
    private int drop = 0;
    PlacableBehaviour placableBehaviour;
    public Gold(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        placableBehaviour = new PlacableOnPath();
    }

    /**
     * Adds gold to inventory.
     * @param world - world state.
     */
    public void transferGold(LoopManiaWorld world) {
        int currentGold = world.getGold();
        world.setGold(currentGold + getDrop());
        
    }

    public void setDrop(int drop) {
        this.drop = drop;
    }
    
    public int getDrop() {
        return drop;
    }

    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "Gold";
    }

}
