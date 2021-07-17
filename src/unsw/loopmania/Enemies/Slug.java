package unsw.loopmania.Enemies;

import unsw.loopmania.PathPosition;

public class Slug extends BasicEnemy {
    public Slug(PathPosition pathPosition) {
        // Gives 1 gold and 1 xp
        // 1 battle radius, 1 support radius (nullifies since == to battle radius)
        super(pathPosition, 10, 5, "Slug", 3, 3, 2, 20); // damage and health current placeholders
    }
}
