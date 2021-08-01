package test.item.weapon;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.item.weapon.Stake;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;


public class StakeTest {
    @Test
    public void testStakeDamageBoost() {
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
        Stake stake = new Stake(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy slug = new Slug(new PathPosition(0, orderedpath));

        character.setWeapon(stake);
        character.dealDamage(slug, 0);
        assertEquals(0, slug.getHealth()); 
    }

    @Test
    public void testStakeSpecial() {
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
        Stake stake = new Stake(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy Vampire = new Vampire(new PathPosition(0, orderedpath));

        character.setWeapon(stake);
        character.dealDamage(Vampire, 0);
        assertEquals(38, Vampire.getHealth());
        assertEquals(stake.toString(), "Stake");
    }
}
