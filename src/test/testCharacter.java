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
    public void blahTest2() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character c = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(c);
        assertEquals(c.getHealth(), 100);
        
        //LoopManiaWorldControllerLoader loopManiaLoader = new LoopManiaWorldControllerLoader("world_with_twists_and_turns.json");
        //LoopManiaWorld d = controller.load();
        //d.setCharacter(character);
        //character = new Character(new PathPosition(0, d.getOrderedPath()));
        //character.getHealth();
        //assertEquals(d.getWidth(), 1);
    }

    @Test
    public void Test1(){
        
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

        // Check character ally
        for (int i = 0; i < 2; i++) {
            character.gainAlly();
            assertEquals(character.getAlly(), i + 1);
        }

        // Check character armour
        character.equipArmour();
        assertEquals(character.getArmourStatus(), true);

        character.unequipArmour();
        assertEquals(character.getArmourStatus(), false);



        // Check character helmet
        character.equipHelmet();
        assertEquals(character.getHelmetStatus(), true);

        character.unequipHelmet();
        assertEquals(character.getHelmetStatus(), false);



        // Check character shield
        character.equipShield();
        assertEquals(character.getShieldStatus(), true);

        character.unequipShield();
        assertEquals(character.getShieldStatus(), false);


    }
}


