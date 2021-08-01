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
import unsw.loopmania.item.weapon.Staff;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;


public class StaffTest {
    @Test
    public void testStaffDamageBoost() {
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
        Staff staff = new Staff(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy slug = new Slug(new PathPosition(0, orderedpath));

        character.setWeapon(staff);
        character.dealDamage(slug, 0);
        assertEquals(3, slug.getHealth()); 
    }

    @Test
    public void testStaffdoSpecial() {
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
        Staff staff = new Staff(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy slug = new Slug(new PathPosition(0, orderedpath));
        slug.setHealth(700);
        character.setWeapon(staff);
        for (int tester = 0; tester < 30; tester++) {
            character.dealDamage(slug, 0);
            
        }
        
        assertEquals(490, slug.getHealth());
        assertEquals(true, staff.getTranchedBool());
        
    }
}
