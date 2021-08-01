package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * This class represents the trap building.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class TrapBuilding extends Building {
    
    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.setRadius(1);
    }
    /**
     * Deals 10 damage to an enemy  that walks on this object
     * @param enemy - enemy entity.
     */
    @Override
    public void DealDamageEnemies(BasicEnemy enemy) {
        int new_health = enemy.getHealth() - 10;
        enemy.setHealth(new_health);
    }

    /**
     * Returns building name as string.
     */
    @Override
    public String toString() {
        return "TrapBuilding";
    }
}
