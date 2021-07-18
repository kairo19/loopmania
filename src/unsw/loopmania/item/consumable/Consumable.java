package unsw.loopmania.item.consumable;

import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;

public abstract class Consumable extends StaticEntity {
    public Consumable(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public abstract void consume(Character character);
}
