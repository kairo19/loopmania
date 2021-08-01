package unsw.loopmania.item.defensiveitem;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableArmour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;

public class Armour extends DefensiveItem {
    private static final double DAMAGE_REDUCTION = 0.5;
    public Armour(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, DAMAGE_REDUCTION);
        this.placableBehaviour = new PlacableArmour();
    } 
       

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Armour";
    }

}


