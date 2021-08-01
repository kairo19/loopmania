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
import unsw.loopmania.Enemies.Zombie;

public class ZombieTest {

    @Test
    public void zombieDealDamage() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Zombie zombie = new Zombie(new PathPosition(0, orderedpath));

        zombie.dealDamage(character);

        assertNotEquals(character.getHealth(), 100);
    }

    @Test
    public void zombieDoSpecial() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Zombie zombie = new Zombie(new PathPosition(0, orderedpath));

        character.setAllies(1);

        while (!zombie.doSpecial(character)) {}

        assertEquals(character.getAllies(), 0);

    }

    @Test
    public void zombieToString() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Zombie zombie = new Zombie(new PathPosition(0, orderedpath));

        //assertEquals(zombie.toString(), "Zombie");

    }
}
