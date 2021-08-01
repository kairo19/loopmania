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
import unsw.loopmania.Enemies.ElanMuske;

public class ElanMuskeTest {

    @Test
    public void ElanMuskeDealDamage() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        ElanMuske elanMuske = new ElanMuske(new PathPosition(0, orderedpath));

        elanMuske.dealDamage(character);

        assertNotEquals(character.getHealth(), 100);
    }

    @Test
    public void ElanMuskeDoSpecial() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        ElanMuske elanMuske = new ElanMuske(new PathPosition(0, orderedpath));

        assertNotEquals(elanMuske.doSpecial(character), true);
    }

    @Test
    public void ElanMuskeIsBoss() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        ElanMuske elanMuske = new ElanMuske(new PathPosition(0, orderedpath));

        assertNotEquals(elanMuske.isBoss(), false);

    }

}