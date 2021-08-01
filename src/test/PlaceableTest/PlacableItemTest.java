package test.PlaceableTest;

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
import unsw.loopmania.Cards.PlacableBehaviour.PlacableArmour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableHealthPotion;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableHelmet;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableShield;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;
import unsw.loopmania.Cards.PlacableBehaviour.PlaceableOnAdjacentPath;

public class PlacableItemTest {
    @Test
    public void PlacableArmourTest() {
        LoopManiaWorld world = initialise();
        PlacableBehaviour armour = new PlacableArmour();

        assertEquals(armour.placable(1, 1, world.getOrderedPath()),false);
        assertEquals(armour.itemPlacable(1, 1), true);
        assertEquals(armour.itemPlacable(1, 2), false);
        
    }
    @Test
    public void PlacableShieldTest() {
        LoopManiaWorld world = initialise();
        PlacableBehaviour shield = new PlacableShield();
        assertEquals(shield.placable(1, 1, world.getOrderedPath()),false);
        assertEquals(shield.itemPlacable(2, 1), true);
        assertEquals(shield.itemPlacable(1, 2), false);

    }
    @Test
    public void PlacableHelmetTest() {
        LoopManiaWorld world = initialise();
        PlacableBehaviour helmet = new PlacableHelmet();
        assertEquals(helmet.placable(1, 1, world.getOrderedPath()),false);
        assertEquals(helmet.itemPlacable(1, 0), true);
        assertEquals(helmet.itemPlacable(1, 2), false);

    }
    @Test
    public void PlacableHealthPotionTest() {
        LoopManiaWorld world = initialise();
        PlacableBehaviour hp = new PlacableHealthPotion();
        assertEquals(hp.placable(1, 1, world.getOrderedPath()),false);
        assertEquals(hp.itemPlacable(2, 0), true);
        assertEquals(hp.itemPlacable(1, 2), false);

    }
    @Test
    public void PlacableWeaponTest() {
        LoopManiaWorld world = initialise();
        PlacableBehaviour weapon = new PlacableWeapon();
        assertEquals(weapon.placable(1, 1, world.getOrderedPath()),false);
        assertEquals(weapon.itemPlacable(0, 1), true);
        assertEquals(weapon.itemPlacable(1, 2), false);

    }

    public LoopManiaWorld initialise() {

        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 2));
        LoopManiaWorld world = new LoopManiaWorld(5, 5, orderedpath);
        Character character = new Character(new PathPosition(1, orderedpath));
        world.setCharacter(character);
        return world;
    }
    
}
