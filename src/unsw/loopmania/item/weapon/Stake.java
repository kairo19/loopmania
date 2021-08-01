package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;

/**
 * This class represents the stake weapon item which boosts attack by 5 damage.
 * The special attack of this weapon deals applies a 1.5x boost to the total character attack when facing a vampire enemy.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class Stake extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 5;
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
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
        if (basicEnemy.getType().equals("Vampire")) {
            character.setBuffedDamage((int) (character.getDamage() * 1.5));
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
        return "Stake";
    }
}
