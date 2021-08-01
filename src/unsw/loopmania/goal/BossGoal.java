package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

/**
 * This class represents goal type with boss requirements.
 * @param loopManiaWorld - world state.
 */

public class BossGoal implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    public BossGoal(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    /**
     * Returns whether goals have been met.
     * @param loopManiaWorld - world state.
     */
    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getDefeatedBosses() == 2;
    }

    /**
     * Returns whether goal is leaf node.
     */
    @Override
    public boolean isLeafNode() {
        return true;
    }

    /**
     * Adds a sub-goal
     * @param subGoal - a sub-goal to add to AND conditions.
     */
    @Override
    public void addSubGoal(GoalNode subGoal) {
        // do nothing
    }

    /**
     * Returns goal condition as string.
     */
    @Override
    public String toString() {
        return "boss";
    }
}
