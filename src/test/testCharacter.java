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

import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import org.javatuples.Pair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;;



public class testCharacter {
    private int gilbert;
    private List<Pair<Integer, Integer>> gilbert2 = null;
    private JSONObject json;
    private LoopManiaWorldLoader loader;
    private LoopManiaWorld d;
    private Character character;
    private LoopManiaWorldControllerLoader controller;

    @Test
    public void TestHealth(){
        
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        assertEquals(character.getHealth(), 100);

        // Check character health
        //d.setCharacter(character);
        //character.getHealth();
        //character.setHealth(120);
        //System.out.println(gilbert);

        character.setHealth(120);
        assertEquals(character.getHealth(), 220);

        character.setHealth(-120);
        assertEquals(character.getHealth(), 100);

    }


    public void TestAlly(){
            
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));

        // Check character ally
        for (int i = 0; i < 2; i++) {
            character.gainAlly();
            assertEquals(character.getAlly(), i + 1);
        }
    }

    public void TestArmour(){
            
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));

        // Check character armour
        character.equipArmour();
        assertEquals(character.getArmourStatus(), true);

        character.unequipArmour();
        assertEquals(character.getArmourStatus(), false);
    }

    public void TestHelmet(){
            
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));

        // Check character helmet
        character.equipHelmet();
        assertEquals(character.getHelmetStatus(), true);

        character.unequipHelmet();
        assertEquals(character.getHelmetStatus(), false);
    }

    public void TestShield(){
            
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));

        // Check character shield
        character.equipShield();
        assertEquals(character.getShieldStatus(), true);

        character.unequipShield();
        assertEquals(character.getShieldStatus(), false);
    }

}