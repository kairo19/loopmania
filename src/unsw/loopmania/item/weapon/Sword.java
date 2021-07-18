package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;
/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 15;  
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableWeapon();
    }

    @Override
    public void damageBoost(Character character) {
        character.setDamage(character.getDamage() + DAMAGE_BOOST);
    }

    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        // do nothing - sword not special :(
    }

    public boolean checkItemplacable(int x, int y){
        
        return placableBehaviour.itemPlacable(x, y);
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Sword";
    }
}
