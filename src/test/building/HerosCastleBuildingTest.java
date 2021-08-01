package test.building;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

import org.javatuples.Pair;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.HerosCastleBuilding;
import unsw.loopmania.Buildings.TowerBuilding;
import unsw.loopmania.Buildings.TrapBuilding;
import unsw.loopmania.Buildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.VillageBuilding;
import unsw.loopmania.Buildings.ZombiePitBuilding;

public class HerosCastleBuildingTest {

    @Test
    public void HerosBuildingPurchaseCycleTest(){

        LoopManiaWorld world = initialise(); 

        HerosCastleBuilding newBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Pair<Integer, Integer> position = new Pair<Integer, Integer>(1, 2);
        int indexInPath = world.getOrderedPath().indexOf(position);
        
        assertEquals(newBuilding.PurchaseCycle(2), true);
        assertEquals(newBuilding.PurchaseCycle(3), false);
    }

    @Test
    public void HerosBuildingSpawnBossTest(){

        LoopManiaWorld world = initialise(); 

        HerosCastleBuilding newBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Pair<Integer, Integer> position = new Pair<Integer, Integer>(1, 2);
        int indexInPath = world.getOrderedPath().indexOf(position);
        BasicEnemy dog = newBuilding.SpawnDoggie(world.getOrderedPath(), position);
        BasicEnemy elon = newBuilding.SpawnElanMuske(world.getOrderedPath(), position);
        assertEquals(dog.toString(), "Doggie");
        assertEquals(elon.toString(), "ElanMuske");
        
    }

    @Test
    public void HerosBuildingStringTest(){
        HerosCastleBuilding newBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        assertEquals(newBuilding.toString(), "HerosCastleBuilding");
        
        
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
