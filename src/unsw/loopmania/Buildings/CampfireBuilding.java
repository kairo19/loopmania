package unsw.loopmania.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;

/**
 * This class represents the campfire building.
 * @param x - building x coord position.
 * @param y - building y coord position.
 */

public class CampfireBuilding extends Building {

    private boolean active = false;
    private int attackBonus = 0;

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        setRadius(3);
    }

    /**
     * Activate character attack damage buff
     * @param character - character entity.
     * @return - total turn character attack damage.
     */
    @Override
    public int CharacterBattleBuffAbility(Character character) {
        
        if (!active) {
            attackBonus = character.getTotalDamage();
        }
        active = true;
        return character.getTotalDamage();
    }

    /**
     * De-activate character attack damage buff
     * @param character - character entity.
     */
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

    /**
     * Returns building name as string.
     */
    @Override
    public String toString() {
        return "CampfireBuilding";
    }
}