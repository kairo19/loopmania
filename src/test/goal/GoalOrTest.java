package test.goal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.GoalExperience;
import unsw.loopmania.goal.GoalGold;
import unsw.loopmania.goal.GoalRound;
import unsw.loopmania.goal.OrGoal;

public class GoalOrTest {
    @Test
    public void testOrGoalSimple() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        OrGoal goal = new OrGoal(world);
        goal.addSubGoal(new GoalGold(world, 100));
        goal.addSubGoal(new GoalExperience(world, 100));
        world.setGoal(goal);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setGold(101);
        assertEquals(true, world.isGameover());
        assertEquals(true, world.hasMetGoal());
    }

    @Test
    public void testOrGoalNested() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        OrGoal orGoal1 = new OrGoal(world);
        OrGoal orGoal2 = new OrGoal(world);
        orGoal2.addSubGoal(new GoalGold(world, 100));
        orGoal2.addSubGoal(new GoalExperience(world, 100));
        orGoal1.addSubGoal(orGoal2);
        orGoal1.addSubGoal(new GoalRound(world, 100));

        world.setGoal(orGoal1);
        assertEquals(false, world.isGameover());
        assertEquals(false, world.hasMetGoal());
        world.setGold(101);
        assertEquals(true, world.isGameover());
        assertEquals(true, world.hasMetGoal());
    }
}
