package unsw.loopmania.goal;

import java.util.ArrayList;

import unsw.loopmania.LoopManiaWorld;

/**
 * This class represents goal type with OR requirements.
 * @param loopManiaWorld - world state.
 */

public class OrGoal implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private ArrayList<GoalNode> subGoals = new ArrayList<GoalNode>();

     public OrGoal(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    /**
     * Returns whether goals have been met.
     * @param loopManiaWorld - world state.
     */
    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        for (int i = 0; i < subGoals.size(); i++) {
            if (subGoals.get(i).hasMetGoal(loopManiaWorld)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns whether goal is leaf node.
     */
    @Override
    public boolean isLeafNode() {
        return false;
    }

    /**
     * Adds a sub-goal
     * @param subGoal - a sub-goal to add to AND conditions.
     */
    @Override
    public void addSubGoal(GoalNode subGoal) {
        subGoals.add(subGoal);
        
    }

    /**
     * Returns goal conditions as concatenated string.
     */
    @Override
    public String toString() {
        String s = "(OR";
        for (int i = 0; i < subGoals.size(); i++) {
            s += " " + subGoals.get(i).toString();
        }
        s += ")";
        return s;
    }
}
