package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

/**
 * This class represents goal type with round requirements.
 * @param loopManiaWorld - world state.
 * @param quantity - rounds for goal criteria.
 */

public class GoalRound implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private int roundGoal;
    public GoalRound(LoopManiaWorld loopManiaWorld, int quantity) {
        this.loopManiaWorld = loopManiaWorld;
        this.roundGoal = quantity;
    }

    /**
     * Returns whether goals have been met.
     * @param loopManiaWorld - world state.
     */
    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getRound() >= roundGoal;
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
     * Returns goal condition as concatenated string.
     */
    @Override
    public String toString() {
        String s = "round : " + roundGoal;
        return s;
    }
}
