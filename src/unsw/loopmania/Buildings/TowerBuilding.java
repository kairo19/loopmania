package unsw.loopmania.Buildings;
import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Enemies.BasicEnemy;

public class TowerBuilding extends Building {
    private int damage;
    public TowerBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(2);
        this.damage = 20;
    }

    @Override
    public int CharacterBattleBuffAbility(Character character) {
        return damage;
    }

    @Override
    public String toString() {
        return "TowerBuilding";
    }
}
