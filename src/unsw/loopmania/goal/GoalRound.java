package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class GoalRound implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    private static final int ROUND_GOAL = 50;
    public GoalRound(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getRound() >= ROUND_GOAL;
    }
}
