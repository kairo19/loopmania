package unsw.loopmania.item;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnPath;
import unsw.loopmania.item.consumable.Consumable;

public class Gold extends StaticEntity{
    private int drop = 0;
    PlacableBehaviour placableBehaviour;
    public Gold(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        placableBehaviour = new PlacableOnPath();
    }

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


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Gold";
    }




}
