package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.LoopManiaWorld;

/**
 * Tests enemy behaviour, stats and functionality.
 */  
// testInit and initialise() currently do not exist.
public class testEnemy extends testInit {
    @Test
    public void testEnemyStats() {
        initialise(); // Initialises game state.
        BasicEnemy enemy = new SlugEnemy(position);
        BasicEnemy enemy2 = new ZombieEnemy(position2);
        BasicEnemy enemy3 = new VampireEnemy(position3);
        
        // Testing that the name of the enemy is correct.
        assertEquals("Slug", enemy.getenemyName());
        assertEquals("Zombie", enemy2.getenemyName());
        assertEquals("Vampire", enemy3.getenemyName());
        
        // Testing that the xp gain values are correct per enemy type.
        assertEquals(10, enemy.getxpReward());
        assertEquals(20, enemy2.getxpReward());
        assertEquals(100, enemy3.getxpReward());
        
        // Testing that the gold drop values are correct per enemy type.
        assertEquals(10, enemy.getgoldReward());
        assertEquals(20, enemy2.getgoldReward());
        assertEquals(100, enemy3.getgoldReward());
        
        // Testing that the battle radii are correct.
        assertEquals(1, enemy.getbattleRadius());
        assertEquals(2, enemy2.getbattleRadius());
        assertEquals(3, enemy3.getbattleRadius());
        
        // Testing that the support radii are correct.
        assertEquals(1, enemy.getsupportRadius());
        assertEquals(1, enemy2.getsupportRadius());
        assertEquals(4, enemy3.getsupportRadius());
        
        // Testing that the critical attack rates are correct.
        assertEquals(0, enemy.getcritRate());
        assertEquals(0.1, enemy2.getcritRate());
        assertEquals(0.2, enemy3.getcritRate());
    }
    
    public void testEnemySpecialAttack() {
        //...
    
    }
    
    public void testEnemyMovement() {
        //...
    
    }
    
    public void testEnemySpawnBehaviour() {
        //...
    }

}
