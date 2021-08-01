package unsw.loopmania.item.defensiveitem;

import unsw.loopmania.StaticEntity;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableShield;

public class Shield extends DefensiveItem implements Block{
    private static final double DAMAGE_REDUCTION = 10.0;  
    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableShield();
    }
    
    // lowerCriticalDamage method here

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Shield";
    }
}
