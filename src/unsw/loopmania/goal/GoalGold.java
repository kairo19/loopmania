package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class GoalGold implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private int goldGoal;
    public GoalGold(LoopManiaWorld loopManiaWorld, int quantity) {
        this.loopManiaWorld = loopManiaWorld;
        this.goldGoal = quantity;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getGold() >= goldGoal;
    }
}
