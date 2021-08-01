package test.enemies;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;

import java.util.List;

public class SlugTest {
    @Test
    public void slugDealDamage() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        slug.dealDamage(character);

        assertEquals(character.getHealth(), 95);
        
    }

    @Test
    public void slugDealDamageArmour() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        Armour equippedArmour = new Armour(null, null);
        character.equipArmour(equippedArmour);

        slug.dealDamage(character);

        assertNotEquals(character.getHealth(), 95);
        
    }

    @Test
    public void slugDealDamageShield() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        Shield equippedShield = new Shield(null, null);
        character.equipShield(equippedShield);

        slug.dealDamage(character);

        assertNotEquals(character.getHealth(), 95);
        
    }

    @Test
    public void slugDealDamageHelmet() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        Helmet equippedHelmet = new Helmet(null, null);
        character.equipHelmet(equippedHelmet);

        slug.dealDamage(character);

        assertNotEquals(character.getHealth(), 95);
        
    }

    @Test
    public void slugCritDamage() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        assertEquals(slug.critDamage(character), false);
    }  

    @Test
    public void slugIsBoss() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        assertEquals(slug.isBoss(), false);
    }

    @Test
    public void slugDoSpecial() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 2, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        assertEquals(slug.doSpecial(character), false);
    } 

    @Test
    public void slugMove() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(5, 6));
        orderedpath.add(new Pair<Integer, Integer>(5, 7));
        orderedpath.add(new Pair<Integer, Integer>(5, 8));
        LoopManiaWorld d = new LoopManiaWorld(10, 10, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        int y = slug.getY();

        slug.move();

        assertNotEquals(slug.getY(), y);
    } 

    @Test
    public void slugMoveUp() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(3, 6));
        orderedpath.add(new Pair<Integer, Integer>(4, 6));
        orderedpath.add(new Pair<Integer, Integer>(5, 6));
        orderedpath.add(new Pair<Integer, Integer>(5, 7));
        orderedpath.add(new Pair<Integer, Integer>(5, 8));
        LoopManiaWorld d = new LoopManiaWorld(10, 10, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        int y = slug.getY();

        slug.moveDownPath();
        slug.moveUpPath();

        assertEquals(slug.getY(), y);
    } 

    @Test
    public void slugMoveDown() {
        List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(3, 6));
        orderedpath.add(new Pair<Integer, Integer>(4, 6));
        orderedpath.add(new Pair<Integer, Integer>(5, 6));
        orderedpath.add(new Pair<Integer, Integer>(5, 7));
        orderedpath.add(new Pair<Integer, Integer>(5, 8));
        LoopManiaWorld d = new LoopManiaWorld(10, 10, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Slug slug = new Slug(new PathPosition(0, orderedpath));

        slug.moveDownPath();

        assertEquals(slug.getX(), 4);
    } 


}
