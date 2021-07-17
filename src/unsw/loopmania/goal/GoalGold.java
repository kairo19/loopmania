package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class GoalGold implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private static final int GOLD_GOAL = 50000;
    public GoalGold(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getGold() >= GOLD_GOAL;
    }
}
