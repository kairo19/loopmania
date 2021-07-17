package unsw.loopmania.goal;

import java.util.ArrayList;

import unsw.loopmania.LoopManiaWorld;

public class OrGoal implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private ArrayList<GoalNode> subGoals = new ArrayList<GoalNode>();

     public OrGoal(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        for (int i = 0; i < subGoals.size(); i++) {
            if (subGoals.get(i).hasMetGoal(loopManiaWorld)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isLeafNode() {
        return false;
    }

    @Override
    public void addSubGoal(GoalNode subGoal) {
        subGoals.add(subGoal);
        
    }
}
