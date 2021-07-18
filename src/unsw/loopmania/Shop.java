package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

import unsw.loopmania.item.consumable.Consumable;
import unsw.loopmania.item.consumable.HealthPotion;

public class Shop {
    private List<StaticEntity> items;
    public Shop(){
        this.items = new ArrayList<>();
        items.add( new HealthPotion());
    }   
}
