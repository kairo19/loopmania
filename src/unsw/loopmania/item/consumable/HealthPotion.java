package unsw.loopmania.item.consumable;

import unsw.loopmania.Character;

public class HealthPotion extends Consumable {
    private static final int HEAL = 40;
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public void consume(Character character) {
        int rejuvinatedHealth = character.getHealth() >= 60 ? 100 : character.getHealth() + HEAL;
        character.setHealth(rejuvinatedHealth);
    }    
}
