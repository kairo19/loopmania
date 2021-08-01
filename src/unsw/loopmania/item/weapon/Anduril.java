package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * This class represents the Anduril weapon item which boosts attack by 25 damage.
 * The special attack of this weapon deals applies 3x the damage boost when facing a boss enemy.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Anduril extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 25;
    public Anduril(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableWeapon();
    }

    /**
     * Applies damage boost to character.
     * @param character - character entity.
     */
    @Override
    public void damageBoost(Character character) {
        character.setBuffedDamage(DAMAGE_BOOST);        
    }

    /**
     * Applies item special attack to an enemy.
     * @param character - character entity.
     * @param basicEnemy - enemy entity.
     */
    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        if (basicEnemy.isBoss()) {
             character.setBuffedDamage(DAMAGE_BOOST * 3);
        }
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
        return "Anduril";
    }

    
}
