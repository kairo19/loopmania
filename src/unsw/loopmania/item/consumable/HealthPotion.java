package unsw.loopmania.item.consumable;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableHealthPotion;

public class HealthPotion extends Consumable {
    // private static final int HEAL = 20;
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableHealthPotion();
    }

    @Override
    public void consume(Character character) {
        if (character.getHealth()  > 100) {
            return;
        }
        character.setHealth(100);
    }    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "HealthPotion";
    }
}
