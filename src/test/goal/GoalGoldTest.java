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
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setGold(101);
        assertEquals(true, world.isGameover());
        assertEquals(true, world.hasMetGoal());
    }
}
