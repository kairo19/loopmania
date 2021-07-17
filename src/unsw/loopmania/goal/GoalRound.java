package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class GoalRound implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private int roundGoal;
    public GoalRound(LoopManiaWorld loopManiaWorld, int quantity) {
        this.loopManiaWorld = loopManiaWorld;
        this.roundGoal = quantity;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getRound() >= roundGoal;
    }
}
