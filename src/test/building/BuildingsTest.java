package test.building;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import unsw.loopmania.Buildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.VillageBuilding;
import unsw.loopmania.Buildings.ZombiePitBuilding;


/**
 * this class is a dummy class demonstrating how to setup tests for the project
 * you should setup additional test classes in a similar fashion, aiming to achieve high coverage.
 * A clickable "Run Test" link should appear if you have installed the Java Extension Pack properly.
 */

public class BuildingsTest {

    
    @Test
    public void ZombieBuildingTest(){
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        List<Building> buildingEntities = new ArrayList<>();


        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 2));
        
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        ZombiePitBuilding newBuilding = new ZombiePitBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(3));
        buildingEntities.add(newBuilding);
        
        assertEquals(newBuilding.SpawnAbility(orderedpath), new Zombie(new PathPosition(1, orderedpath)));
    }

    
    @Test
    public void TowerBuildingTest(){

        LoopManiaWorld world = initialise();
        
        List<Building> buildingEntities = new ArrayList<>();
        List<BasicEnemy> enemies = new ArrayList<>();

        TowerBuilding newBuilding = new TowerBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        buildingEntities.add(newBuilding);

        world.setBuildingEntities(buildingEntities);
        buildingEntities.add(newBuilding);
        
        Slug enemy = new Slug(new PathPosition(1,world.getOrderedPath()));
        enemies.add(enemy);
        world.setEnemies(enemies);
        world.runBattles();
        assert(enemies.size() == 0);
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
}
