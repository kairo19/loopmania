package unsw.loopmania.goal;

import java.util.ArrayList;

import unsw.loopmania.LoopManiaWorld;

public class AndGoal implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private ArrayList<GoalNode> subGoals = new ArrayList<GoalNode>();

    public AndGoal(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        for (int i = 0; i < subGoals.size(); i++) {
            if (!subGoals.get(i).hasMetGoal(loopManiaWorld)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isLeafNode() {
        return false;
    }

    @Override
    public void addSubGoal(GoalNode subGoal) {
        subGoals.add(subGoal);
    }

    @Override
    public String toString() {
        String s = "(AND";
        for (int i = 0; i < subGoals.size(); i++) {
            s += " " + subGoals.get(i).toString();
        }
        s += ")";
        return s;
    }
}
