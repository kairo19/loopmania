package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;

public class TrapBuilding extends Building {
    
    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.setRadius(1);
    }
    /**
     * Deals 50 damage to an enemy  that walks on this object
     * @param Enemy
     */
    @Override
    public void DealDamageEnemies(BasicEnemy enemy) {
        int new_health = enemy.getHealth() - 50;
        enemy.setHealth(new_health);
    }


    @Override
    public String toString() {
        return "TrapBuilding";
    }
}
