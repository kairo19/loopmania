package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Pair;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.Buildings.Building;
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
    public void blahTest(){
        assertEquals("a", "a");
    }
    
    @Test
    public void VampireBuildingTest(){
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        List<Building> buildingEntities = new ArrayList<>();


        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 2));
        
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        VampireCastleBuilding newBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(3));
        buildingEntities.add(newBuilding);
        
        assertEquals(newBuilding.SpawnVampire(5), new Vampire());
    }

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
        
        assertEquals(newBuilding.SpawnZombie(5), new Zombie());
    }

    @Test
    public void VillageBuildingTest(){
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        List<Building> buildingEntities = new ArrayList<>();


        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 2));
        
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        VillageBuilding newBuilding = new VillageBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        buildingEntities.add(newBuilding);

        Character character = new Character();
        int new_health = character.getHealth() + 50;
        newBuilding.RegainHealth(character);
        assertEquals(new_health, character.gethealth());
    }
}
