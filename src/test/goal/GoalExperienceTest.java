package test.goal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.GoalExperience;

public class GoalExperienceTest {
    @Test
    public void testExperienceGoal() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        GoalExperience goal = new GoalExperience(world, 100);
        world.setGoal(goal);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setExperience(101);
        assertEquals(true, world.isGameover());
        assertEquals(true, world.hasMetGoal());
    }
}
