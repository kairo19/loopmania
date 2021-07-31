package unsw.loopmania.item.weapon;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableWeapon;
import unsw.loopmania.Enemies.BasicEnemy;

public class Anduril extends StaticEntity implements Weapon {
    private static final int DAMAGE_BOOST = 15;
    public Anduril(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.placableBehaviour = new PlacableWeapon();
    }
    @Override
    public void damageBoost(Character character) {
        character.setBuffedDamage(DAMAGE_BOOST);        
    }

    @Override
    public void doSpecial(BasicEnemy basicEnemy, Character character) {
        if (basicEnemy.isBoss()) {
             character.setBuffedDamage(DAMAGE_BOOST * 3);
        }
    }
    
    public boolean checkItemplacable(int x, int y){
        return placableBehaviour.itemPlacable(x, y);
    }

    @Override
    public String toString() {
        return "Anduril";
    }

    
}
