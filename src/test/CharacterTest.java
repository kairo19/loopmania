package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import javafx.collections.SetChangeListener;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.LoopManiaWorldController;
import unsw.loopmania.LoopManiaWorldControllerLoader;
import unsw.loopmania.LoopManiaWorldLoader;
import unsw.loopmania.PathPosition;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.DefensiveItem;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
import unsw.loopmania.item.weapon.Weapon;
import unsw.loopmania.Enemies.Slug;

import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import org.javatuples.Pair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class CharacterTest {
    private List<Pair<Integer, Integer>> gilbert2 = null;
    private JSONObject json;
    private LoopManiaWorldLoader loader;
    private LoopManiaWorld d;
    private Character character;
    private LoopManiaWorldControllerLoader controller;

    private Armour equippedArmour;
    private Helmet equippedHelmet;
    private Shield equippedShield;
    private Weapon equippedWeapon;

    @Test
    public void TestHealth(){
        
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        assertEquals(character.getHealth(), 100);

        character.setHealth(120);
        assertEquals(character.getHealth(), 120);

    }

    @Test
    public void TestgainAlly(){
        
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        for (int i = 0; i < 2; i++) {
            character.gainAlly();
            assertEquals(character.getAlly(), i + 1);
            
        }

        character.loseAlly();
        assertEquals(character.getAlly(), 1);

    }

    @Test
    public void TestArmour(){

        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        character.equipArmour(equippedArmour);
        assertEquals(character.getArmour(), equippedArmour);

        character.unequipArmour();
        assertEquals(character.getArmour(), null);

    }

    @Test
    public void TestHelmet(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        
        character.equipHelmet(equippedHelmet);
        assertEquals(character.getHelmet(), equippedHelmet);

        character.unequipHelmet();
        assertEquals(character.getHelmet(), null);
    }

    @Test
    public void TestShield(){

        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        
        character.equipShield(equippedShield);
        assertEquals(character.getShield(), equippedShield);

        character.unequipShield();
        assertEquals(character.getShield(), null);
    }

    @Test
    public void TestWeapon(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        
        character.setWeapon(equippedWeapon);
        assertEquals(character.getWeapon(), equippedShield);

        character.removeWeapon();
        assertEquals(character.getWeapon(), null);
    }

    @Test
    public void testDealDamage(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        character.dealDamage(slug, 0);

        assertEquals(slug.getHealth(), 5);


    }

    



    




}
