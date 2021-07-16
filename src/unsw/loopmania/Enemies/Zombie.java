package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;

public class Zombie extends BasicEnemy implements CriticalStriker {
    public Zombie(PathPosition pathPosition) {
        super(pathPosition, 25, 10, "Zombie");
    }

    @Override
    public void doCrit(Character character) {
        // Random r = new Random();
        // int chance = r.nextInt(100);
        // if (chance < 10) {
        //     character.loseAlly();
        //     // spawn new zombie
        // }
    }
}
