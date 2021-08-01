package unsw.loopmania.item;

import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.item.consumable.HealthPotion;
import unsw.loopmania.item.consumable.TheOneRing;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
import unsw.loopmania.item.defensiveitem.TreeStump;
import unsw.loopmania.item.weapon.Anduril;
import unsw.loopmania.item.weapon.Staff;
import unsw.loopmania.item.weapon.Stake;
import unsw.loopmania.item.weapon.Sword;

public class ItemFactory {
    //private Random random = new Random();

    // create here
    public StaticEntity makeItems(SimpleIntegerProperty x, SimpleIntegerProperty y) {

        Random r = new Random();
        int num = r.nextInt(7);

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
            case 6:
                return new HealthPotion(x, y);
                
        }

        return null;
    }

    public StaticEntity makeRareItems(SimpleIntegerProperty x, SimpleIntegerProperty y) {

        Random r = new Random();
        int num = r.nextInt(100);

        switch (num) {
            case 0:
                return new TheOneRing(x, y);
            case 1:
                return new Anduril(x, y);
            case 2:
                return new TreeStump(x, y);
        }

        return null;
    }

}