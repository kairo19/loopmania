package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class GoalExperience implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private int experienceGoal;
    public GoalExperience(LoopManiaWorld loopManiaWorld, int quantity) {
        this.loopManiaWorld = loopManiaWorld;
        this.experienceGoal = quantity;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getExperience() >= experienceGoal;
    }

    @Override
    public boolean isLeafNode() {
        return true;
    }

    @Override
    public void addSubGoal(GoalNode subGoal) {
        // do nothing
    }

    @Override
    public String toString() {
        String s = "experience : " + experienceGoal;
        return s;
    }
}
