package test.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.item.DoggieCoin;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;

public class DoggieCoinTest {
    @Test
    public void doggieFluctuatetest() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 1, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        DoggieCoin doggieCoin = new DoggieCoin(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        System.out.println(doggieCoin);
        for (int test = 0; test < 10; test++) {
            doggieCoin.fluctuate(false, 10);
            System.out.println("fluctuating");
            System.out.println(doggieCoin.getValueProperty());
        }
        doggieCoin.fluctuate(true, 10);
        doggieCoin.fluctuate(false, 10);
        boolean checker = false;
        if (doggieCoin.getValueProperty() > 0) {
            checker = true;
        }
        System.out.println(doggieCoin.getValueProperty());

        assertEquals(true, checker);

    }
}