package test.goal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.GoalGold;

public class GoalGoldTest {
    @Test
    public void testGoldGoal() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        GoalGold goal = new GoalGold(world, 100);
        world.setGoal(goal);
        assertEquals(false, goal.hasMetGoal(world));
        world.setGold(101);
        assertEquals(true, goal.hasMetGoal(world));
    }
}
