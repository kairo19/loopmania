package unsw.loopmania.item;

import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.item.consumable.HealthPotion;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
import unsw.loopmania.item.weapon.Staff;
import unsw.loopmania.item.weapon.Stake;
import unsw.loopmania.item.weapon.Sword;

public class ItemFactory {
    //private Random random = new Random();

    // create here
    public StaticEntity makeItems(SimpleIntegerProperty x, SimpleIntegerProperty y) {

        Random r = new Random();
        int num = r.nextInt(6);

        
        // rare items insert



        switch(num) {
            case 0: 
                return new Sword(x, y);
            case 1: 
                return new Staff(x, y);
            case 2:
                return new Stake(x, y);
            case 3:
                return new Armour(x, y);
            case 4:
                return new Helmet(x, y);
            case 5:
                return new Shield(x, y);
                //return new HealthPotion(x, y);
                
        }

        return null;
    }


    /*
    public StaticEntity createHealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new HealthPotion(x, y);
    }

    public StaticEntity createArmour(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new Armour(x, y);
    }

    public StaticEntity createHelmet(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new Helmet(x, y);
    }

    public StaticEntity createShield(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new Shield(x, y);
    }

    public StaticEntity createStaff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new Staff(x, y);
    }

    public StaticEntity createStake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new Stake(x, y);
    }

    public StaticEntity createSword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        return new Sword(x, y);
    }
    
    */
}
