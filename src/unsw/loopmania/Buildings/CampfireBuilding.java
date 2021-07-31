package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;


public class CampfireBuilding extends Building {

    private boolean active = false;
    private int attackBonus = 0;

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(3);
    }

    @Override
    public int CharacterBattleBuffAbility(Character character) {
        
        if (!active) {
            attackBonus = character.getTotalDamage();
        }
        active = true;
        return character.getTotalDamage();
    }

    public void CharacterBattleDebuffAbility(Character character) {
        if (active) {
            active = false;
        } 
        attackBonus = 0;
    }
    
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public String toString() {
        return "CampfireBuilding";
    }
}