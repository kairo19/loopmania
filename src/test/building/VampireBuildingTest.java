package test.building;

import unsw.loopmania.LoopManiaWorld;
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

public class VampireBuildingTest {
    @Test
    public void VampireBuildingSpawnTest(){

        LoopManiaWorld world = initialise();

        List<Building> buildingEntities = new ArrayList<>();
        List<BasicEnemy> enemies = new ArrayList<>();
        VampireCastleBuilding newBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(3));
        buildingEntities.add(newBuilding);
        Pair<Integer, Integer> position = new Pair<Integer, Integer>(1, 2);
        int indexInPath = world.getOrderedPath().indexOf(position);
        BasicEnemy enemy = newBuilding.SpawnAbility(world.getOrderedPath());
        enemies.add(enemy);
        assertEquals(enemies.size(), 1);
    }

    @Test
    public void VampireBuildingAliveTest(){

        LoopManiaWorld world = initialise();

        List<Building> buildingEntities = new ArrayList<>();
        VampireCastleBuilding newBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(3));
        buildingEntities.add(newBuilding);

        newBuilding.addBuildingAlive();
        newBuilding.addBuildingAlive();
        newBuilding.addBuildingAlive();
        newBuilding.addBuildingAlive();
        newBuilding.addBuildingAlive();



        assertEquals(5, newBuilding.getBuildingAliveRounds());
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
