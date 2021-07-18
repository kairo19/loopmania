package unsw.loopmania.item.consumable;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;

public class TheOneRing extends Consumable {
    private static final int FULL_HEALTH = 100;
    public TheOneRing(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public void consume(Character character) {
        character.setHealth(FULL_HEALTH);        
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "TheOneRing";
    }
}
