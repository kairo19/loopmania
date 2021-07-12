package unsw.loopmania.Enemies;

import unsw.loopmania.BasicEnemy;
import unsw.loopmania.PathPosition;

public class Zombie extends BasicEnemy {
    public Zombie(PathPosition pathPosition) {
        super(pathPosition, 25, 10, "Zombie");
    }
}
