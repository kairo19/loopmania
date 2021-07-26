package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

public class BossGoal implements GoalNode {
    private LoopManiaWorld loopManiaWorld;
    public BossGoal(LoopManiaWorld loopManiaWorld) {
        this.loopManiaWorld = loopManiaWorld;
    }

    @Override
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld) {
        return loopManiaWorld.getDefeatedBosses() == 2;
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
        return "boss";
    }
}
