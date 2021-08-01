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
import unsw.loopmania.Enemies.Doggie;

public class DoggieTest {

    @Test
    public void doggieDealDamage() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Doggie doggie = new Doggie(new PathPosition(0, orderedpath));

        doggie.dealDamage(character);

        assertNotEquals(character.getHealth(), 100);
    }

    @Test
    public void doggieDoSpecial() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Doggie doggie = new Doggie(new PathPosition(0, orderedpath));

        boolean bool = false;
        int count = 0;

        while (!bool) {
            bool = doggie.doSpecial(character);
            count++;
        }

        int health = Math.abs(character.getHealth());
        int check = health/count;

        assertNotEquals(count, check);

    }

    @Test
    public void doggieIsBoss() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Doggie doggie = new Doggie(new PathPosition(0, orderedpath));

        assertNotEquals(doggie.isBoss(), false);

    }


}
