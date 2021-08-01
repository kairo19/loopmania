package unsw.loopmania.Buildings;
import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * This class represents the tower building.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class TowerBuilding extends Building {
    private int damage;
    public TowerBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(3);
        this.damage = 5;
    }

    /**
     * Returns bonus damage to be done by character.
     * @param character
     */
    @Override
    public int CharacterBattleBuffAbility(Character character) {
        return damage;
    }

    /**
     * Returns building name as string.
     */
    @Override
    public String toString() {
        return "TowerBuilding";
    }
}
