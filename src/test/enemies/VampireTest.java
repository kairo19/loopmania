package test.enemies;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.item.defensiveitem.Shield;

public class VampireTest {

    @Test
    public void vampireDealDamage() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Vampire vampire = new Vampire(new PathPosition(0, orderedpath));

        vampire.dealDamage(character);

        assertNotEquals(character.getHealth(), 100);
    }

    @Test
    public void vampireDealDamageShield() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Vampire vampire = new Vampire(new PathPosition(0, orderedpath));

        Shield equippedShield = new Shield(null, null);
        character.equipShield(equippedShield);

        vampire.dealDamage(character);

        assertNotEquals(character.getHealth(), 100);
    }

    @Test
    public void vampireDoSpecial() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Vampire vampire = new Vampire(new PathPosition(0, orderedpath));

        for (int i = 0; i < 100; i++) {
            vampire.dealDamage(character);
        }

        character.setHealth(1000);

        vampire.critDamage(character);

        int health = Math.abs(vampire.getHealth());

        health = health % 20;

        assertNotEquals(health, 0);
        
    }
}
