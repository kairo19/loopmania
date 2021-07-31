package test.goal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.GoalExperience;

public class GoalExperienceTest {
    @Test
    public void testHasMetGoal() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        GoalExperience goal = new GoalExperience(world, 100);
        world.setGoal(goal);
        assertEquals(false, goal.hasMetGoal(world));
        world.setExperience(101);
        assertEquals(true, goal.hasMetGoal(world));
    }

    @Test
    public void testToString() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        GoalExperience goal = new GoalExperience(world, 100);
        assertEquals("experience : 100", goal.toString());
    }
}
