package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

public class Vampire extends BasicEnemy implements CriticalStriker {
    public Vampire(PathPosition pathPosition) {
        // Gives 4 gold and 4 xp
        // 3 battle radius, 5 support radius
        super(pathPosition, 50, 20, "Vampire", 4, 4, 3, 5);
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
        int randomHits = r.nextInt(5);
        if (chance< 20) {
          for (int i = 0; i < randomHits; i++) {
                int additionalAttack = r.nextInt(5);
                // apply additional attack here?
            } 
        }
    }
}
