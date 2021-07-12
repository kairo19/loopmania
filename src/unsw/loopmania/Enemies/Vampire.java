package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;

public class Vampire extends BasicEnemy implements CriticalStriker {
    public Vampire(PathPosition pathPosition) {
        super(pathPosition, 50, 20, "Vampire");
    }

    @Override
    public void doCrit(Character character) {
        // Random r = new Random();
        // int chance = r.nextInt(100);
        // int randomHits = r.nextInt(5);
        // if (chance< 20) {
        //     for (int i = 0; i < randomHits; i++) {
        //         int additionalAttack = r.nextInt(5);
        //         // apply additional attack here?
        //     } 
        // }
    }
}
