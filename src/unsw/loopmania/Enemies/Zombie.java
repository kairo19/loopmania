package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

public class Zombie extends BasicEnemy implements CriticalStriker {
    public Zombie(PathPosition pathPosition) {
        // Gives 2 gold and 2 xp
        // 2 battle radius, 2 support radius (nullifies since == to battle radius)
        super(pathPosition, 25, 10, "Zombie", 4, 4, 2, 2);
    }

    @Override
    public void dealDamage(Character character, int extraDamage) {
        super.dealDamage(character, extraDamage);
        doCrit(character);
    }

    @Override
    public void doCrit(Character character) {
        Random r = new Random();
        int chance = r.nextInt(100);
        if (chance < 10) {
            character.loseAlly();
            // spawn new zombie
        }
    }
}

