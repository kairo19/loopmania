package test.item.weapon;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.item.weapon.Sword;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;


public class SwordTest {
    @Test
    public void testSwordDamageBoost() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Sword sword = new Sword(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy zombie = new Zombie(new PathPosition(0, orderedpath));

        character.setWeapon(sword);
        character.dealDamage(zombie, 0);
        assertEquals(10, zombie.getHealth());
        assertEquals(sword.toString(), "Sword");
    }

    
}
