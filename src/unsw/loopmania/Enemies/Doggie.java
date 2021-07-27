package unsw.loopmania.Enemies;


import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

public class Doggie extends BasicEnemy implements SpecialAbility{
    public Doggie(PathPosition pathPosition) {
        // Gives 1 gold and 1 xp
        // 2 battle radius, 2 support radius (nullifies since == to battle radius)
        super(pathPosition, 100, 40, "Doggie", 16, 16, 2, 2); // damage and health current placeholders
    }

    @Override
    public void dealDamage(Character character) {
        super.dealDamage(character);
        doSpecial(character);
    }

    @Override
    public void doSpecial(Character character) {
        // needs to be implemented
    }
}
