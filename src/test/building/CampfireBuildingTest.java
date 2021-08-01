package test.building;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
import unsw.loopmania.Buildings.CampfireBuilding;
import unsw.loopmania.Buildings.HerosCastleBuilding;
import unsw.loopmania.Buildings.TowerBuilding;
import unsw.loopmania.Buildings.TrapBuilding;
import unsw.loopmania.Buildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.VillageBuilding;
import unsw.loopmania.Buildings.ZombiePitBuilding;

public class CampfireBuildingTest {

    @Test
    public void CampfireBuildingBuffTest(){

        LoopManiaWorld world = initialise(); 

        CampfireBuilding newBuilding = new CampfireBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        Pair<Integer, Integer> position = new Pair<Integer, Integer>(1, 2);
        int indexInPath = world.getOrderedPath().indexOf(position);
        
        
        newBuilding.CharacterBattleBuffAbility(world.getCharacter());
        assertEquals(newBuilding.getActive(), true);
        assertEquals(newBuilding.getAttackBonus(), 5);
        newBuilding.CharacterBattleDebuffAbility(world.getCharacter());
        assertEquals(newBuilding.getActive(), false);
    }

    @Test
    public void CampfireBuildingtoStringTest() {
        CampfireBuilding newBuilding = new CampfireBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        assertEquals(newBuilding.toString(), "CampfireBuilding");
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
