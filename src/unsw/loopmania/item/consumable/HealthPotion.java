package unsw.loopmania.item.consumable;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableConsumable;

public class HealthPotion extends Consumable {
    private static final int HEAL = 40;
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableConsumable();
    }

    @Override
    public void consume(Character character) {
        int rejuvinatedHealth = character.getHealth() >= 60 ? 100 : character.getHealth() + HEAL;
        character.setHealth(rejuvinatedHealth);
    }    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "HealthPotion";
    }
}
