package test.item;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.ElanMuske;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.item.defensiveitem.TreeStump;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;

public class TreeStumpTest {
    @Test
    public void treeStumpDamageReductionTest() {
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
        TreeStump treeStump = new TreeStump(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy vampire = new Vampire(new PathPosition(0, orderedpath));

        character.equipShield(treeStump);
        vampire.setDamage(50);
        vampire.dealDamage(character);

        assertEquals(70, character.getHealth());
    }
    @Test
    public void treeStumpisBoss() {
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
        TreeStump treeStump = new TreeStump(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy elanMusk = new ElanMuske(new PathPosition(0, orderedpath));

        character.equipShield(treeStump);
        elanMusk.setDamage(120);
        elanMusk.dealDamage(character);

        assertEquals(40, character.getHealth());
    }
}