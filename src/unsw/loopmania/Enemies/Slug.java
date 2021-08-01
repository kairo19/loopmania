package unsw.loopmania.Enemies;

import unsw.loopmania.PathPosition;

/**
 * This class represents a slug enemy.
 * @param pathPosition - enemy position on path.
 */

public class Slug extends BasicEnemy {
    public Slug(PathPosition pathPosition) {
        // 2 battle radius, 2 support radius (nullifies since == to battle radius)
        super(pathPosition, 10, 5, "Slug", 3, 3, 2, 2); // damage and health current placeholders
    }

    /**
     * Returns enemy name as string.
     */
    @Override
    public String toString() {
        return "Slug";
    }
}
