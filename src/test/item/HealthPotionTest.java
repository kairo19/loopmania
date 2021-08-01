package test.item;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.item.consumable.HealthPotion;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;

public class HealthPotionTest {
    @Test
    public void potionConsumeTest () {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 1, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        HealthPotion healthPotion = new HealthPotion(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        character.setHealth(20);
        
        healthPotion.consume(character);
        

        assertEquals(100, character.getHealth());
        assertEquals("HealthPotion", healthPotion.toString());

    }
    
}
