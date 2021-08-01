package test.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import unsw.loopmania.PathPosition;
import unsw.loopmania.item.Gold;
import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;

public class GoldTest {
    @Test
    public void goldTransferTest() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        LoopManiaWorld d = new LoopManiaWorld(1, 1, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        Gold gold = new Gold(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        gold.setDrop(50);
        gold.transferGold(d);

        assertEquals(50,d.getgoldProperty().get());

    }
    
}
