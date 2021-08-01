package test.building;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

import org.javatuples.Pair;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.TowerBuilding;
import unsw.loopmania.Buildings.TrapBuilding;
import unsw.loopmania.Buildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.VillageBuilding;
import unsw.loopmania.Buildings.ZombiePitBuilding;
public class TrapBuildingTest {

    @Test
    public void TrapBuildingKillEnemyTest(){

        LoopManiaWorld world = initialise(); 

        TrapBuilding newBuilding = new TrapBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Pair<Integer, Integer> position = new Pair<Integer, Integer>(1, 2);
        int indexInPath = world.getOrderedPath().indexOf(position);
        BasicEnemy enemy = new Zombie(new PathPosition(indexInPath, world.getOrderedPath()));
        newBuilding.DealDamageEnemies(enemy);
        assertEquals(enemy.getHealth(), 15);
    }

    public LoopManiaWorld initialise() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 2));
        LoopManiaWorld world = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(1, orderedpath));
        world.setCharacter(character);
        return world;
    }
    @Test
    public void TrapBuildingStringTest(){
        LoopManiaWorld world = initialise();
        TrapBuilding newBuilding = new TrapBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        assertEquals("TrapBuilding", newBuilding.toString());
    }
}
