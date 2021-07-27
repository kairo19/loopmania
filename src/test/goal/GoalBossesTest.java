package test.goal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.BossGoal;

public class GoalBossesTest {
    @Test
    public void testBossesGoal() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        BossGoal goal = new BossGoal(world);
        world.setGoal(goal);
        assertEquals(false, goal.hasMetGoal(world));
        world.addDefeatedBoss();
        world.addDefeatedBoss();
        assertEquals(true, goal.hasMetGoal(world));
    }
}
