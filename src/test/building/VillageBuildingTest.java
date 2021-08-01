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

public class VillageBuildingTest {
    
    @Test
    public void VillageBuildingMaxHealthTest(){
        LoopManiaWorld world = initialise();

        List<Building> buildingEntities = new ArrayList<>();
        VillageBuilding newBuilding = new VillageBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        buildingEntities.add(newBuilding);
        
    
        newBuilding.CharacterBattleBuffAbility(world.getCharacter());
        assertEquals(100, world.getCharacter().getHealth());
    }
    @Test
    public void VillageBuildingLessHealthTest(){
        LoopManiaWorld world = initialise();

        List<Building> buildingEntities = new ArrayList<>();
        VillageBuilding newBuilding = new VillageBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        buildingEntities.add(newBuilding);
        BasicEnemy zombie = new Zombie(new PathPosition(1, world.getOrderedPath()));
        zombie.dealDamage(world.getCharacter());
        newBuilding.CharacterBattleBuffAbility(world.getCharacter());
        assertEquals(100, world.getCharacter().getHealth());
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
    public void VillageBuildingStringTest(){
        VillageBuilding newBuilding = new VillageBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        assertEquals("VillageBuilding", newBuilding.toString());
    }

}
