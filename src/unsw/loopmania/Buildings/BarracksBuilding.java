package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;

public class BarracksBuilding extends Building {

    public BarracksBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
    public void AddAlly(Character character) {
        character.ally += 1;
    }

}

