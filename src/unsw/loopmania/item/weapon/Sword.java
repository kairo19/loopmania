package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;

/**
 * This class represents the sword weapon item which boosts attack by 15 damage.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Sword extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 15;  
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableWeapon();
    }

    /**
     * Applies damage boost to character.
     * @param character - character entity.
     */
    @Override
    public void damageBoost(Character character) {
        //character.setDamage(character.getDamage() + DAMAGE_BOOST);
        character.setBuffedDamage(DAMAGE_BOOST);
    }

    /**
     * Applies item special attack to an enemy.
     * @param character - character entity.
     * @param basicEnemy - enemy entity.
     */
    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        // do nothing - sword not special :(
    }

    /**
     * Checks whether item is placable.
     */
    public boolean checkItemplacable(int x, int y){
        
        return placableBehaviour.itemPlacable(x, y);
    }

    /**
     * Returns item name as string.
     */
    @Override
    public String toString() {
        return "Sword";
    }
}
