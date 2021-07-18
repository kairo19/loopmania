package unsw.loopmania.item.consumable;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableTheOneRing;

public abstract class Consumable extends StaticEntity {
    public Consumable(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableTheOneRing();
    }

    public abstract void consume(Character character);

    public boolean checkItemPlacable(int x, int y) {
        return placableBehaviour.itemPlacable(x, y);
    }
}
