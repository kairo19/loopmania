package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class OrGoal implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private GoalNode goalChildOne;
    private GoalNode goalChildTwo;

    public OrGoal(LoopManiaWorld loopManiaWorld, GoalNode goalChildOne, GoalNode goalChildTwo) {
        this.loopManiaWorld = loopManiaWorld;
        this.goalChildOne = goalChildOne;
        this.goalChildTwo = goalChildTwo;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return goalChildOne.hasMetGoal(loopManiaWorld) || goalChildTwo.hasMetGoal(loopManiaWorld);
    }
}
