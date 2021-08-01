
package test.item.weapon;

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
import unsw.loopmania.item.weapon.Anduril;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
public class AndurilTest {
    @Test
    public void testAndurilDamage(){
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
        Anduril anduril = new Anduril(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy vampire = new Vampire(new PathPosition(0, orderedpath));

        character.setWeapon(anduril);
        character.dealDamage(vampire, 0);
        assertEquals(20, vampire.getHealth());
    }
    @Test
    public void testAndurildoSpecial(){
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
        Anduril anduril = new Anduril(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        BasicEnemy elanmuske = new ElanMuske(new PathPosition(0, orderedpath));

        character.setWeapon(anduril);
        character.dealDamage(elanmuske, 0);
        assertEquals(920, elanmuske.getHealth());
        assertEquals(anduril.toString(), "Anduril");
    }
}
