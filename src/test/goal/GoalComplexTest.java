package test.goal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.goal.AndGoal;
import unsw.loopmania.goal.BossGoal;
import unsw.loopmania.goal.GoalExperience;
import unsw.loopmania.goal.GoalGold;
import unsw.loopmania.goal.OrGoal;

public class GoalComplexTest {
    @Test
    public void testComplexGoalUno() {
        LoopManiaWorld world = new LoopManiaWorld(1, 2, new ArrayList<>());
        OrGoal orGoal = new OrGoal(world);
        AndGoal andGoal = new AndGoal(world);
        andGoal.addSubGoal(new GoalGold(world, 100));
        andGoal.addSubGoal(new GoalExperience(world, 100));
        orGoal.addSubGoal(andGoal);
        orGoal.addSubGoal(new BossGoal(world));
        world.setGoal(orGoal);
        assertEquals(false, orGoal.hasMetGoal(world));
        world.setGold(101);
        assertEquals(false, orGoal.hasMetGoal(world));
        world.addDefeatedBoss();
        world.addDefeatedBoss();
        assertEquals(true, orGoal.hasMetGoal(world));
    }
}
