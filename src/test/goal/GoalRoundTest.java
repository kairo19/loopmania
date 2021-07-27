package test.goal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.GoalRound;

public class GoalRoundTest {
    @Test
    public void testRoundGoal() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        GoalRound goal = new GoalRound(world, 100);
        world.setGoal(goal);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setRound(101);
        assertEquals(true, world.isGameover());
        assertEquals(true, world.hasMetGoal());
    }
}
