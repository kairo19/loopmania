package test.goal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.AndGoal;
import unsw.loopmania.goal.GoalExperience;
import unsw.loopmania.goal.GoalGold;
import unsw.loopmania.goal.GoalRound;

public class GoalAndTest {
    @Test
    public void hasMetGoalSimple() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        AndGoal goal = new AndGoal(world);
        goal.addSubGoal(new GoalGold(world, 100));
        goal.addSubGoal(new GoalExperience(world, 100));
        world.setGoal(goal);
        assertEquals(false, goal.hasMetGoal(world));
        world.setGold(101);
        assertEquals(false, goal.hasMetGoal(world));
        world.setExperience(101);
        assertEquals(true, goal.hasMetGoal(world));
    }

    @Test
    public void hasMetGoalNested() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        AndGoal andGoal1 = new AndGoal(world);
        AndGoal andGoal2 = new AndGoal(world);
        andGoal2.addSubGoal(new GoalGold(world, 100));
        andGoal2.addSubGoal(new GoalExperience(world, 100));
        andGoal1.addSubGoal(andGoal2);
        andGoal1.addSubGoal(new GoalRound(world, 100));

        world.setGoal(andGoal1);
        assertEquals(false, andGoal1.hasMetGoal(world));
        world.setGold(101);
        assertEquals(false, andGoal1.hasMetGoal(world));
        world.setExperience(101);
        assertEquals(false, andGoal1.hasMetGoal(world));
        world.setRound(101);
        assertEquals(true, andGoal1.hasMetGoal(world));
    }

    @Test 
    public void testToString() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        AndGoal goal = new AndGoal(world);
        goal.addSubGoal(new GoalGold(world, 100));
        goal.addSubGoal(new GoalExperience(world, 100));
        assertEquals("(AND gold : 100 experience : 100)", goal.toString());
    }
}
