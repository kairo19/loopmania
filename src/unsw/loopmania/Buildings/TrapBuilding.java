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
    public void TrapEnemy(BasicEnemy Enemy) {
        int new_health = Enemy.getHealth() - 50;
        Enemy.setHealth(new_health);
    }

    @Override
    public String toString() {
        return "TrapBuilding";
    }
}
