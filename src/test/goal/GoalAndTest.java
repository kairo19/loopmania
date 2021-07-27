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
    public void testAndGoalSimple() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        AndGoal goal = new AndGoal(world);
        goal.addSubGoal(new GoalGold(world, 100));
        goal.addSubGoal(new GoalExperience(world, 100));
        world.setGoal(goal);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setGold(101);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setExperience(101);
        assertEquals(true, world.isGameover());
        assertEquals(true, world.hasMetGoal());
    }

    @Test
    public void testAndGoalsNested() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        AndGoal andGoal1 = new AndGoal(world);
        AndGoal andGoal2 = new AndGoal(world);
        andGoal2.addSubGoal(new GoalGold(world, 100));
        andGoal2.addSubGoal(new GoalExperience(world, 100));
        andGoal1.addSubGoal(andGoal2);
        andGoal1.addSubGoal(new GoalRound(world, 100));

        world.setGoal(andGoal1);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setGold(101);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setExperience(101);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setRound(101);
        assertEquals(true, world.isGameover());
        assertEquals(true, world.hasMetGoal());
    }
}
