package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class GoalExperience implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private static final int EXPERIENCE_GOAL = 100000;
    public GoalExperience(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getExperience() >= EXPERIENCE_GOAL;
    }
}
