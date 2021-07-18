package unsw.loopmania.Buildings;
import java.util.List;
import org.javatuples.Pair;


import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.BasicEnemy;

public abstract class Building extends StaticEntity {
    private int radius;
    private int BuildingAliveRounds;
    //private PathPosition position;
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.radius = 0;
        this.BuildingAliveRounds = 0;
    }   
    
    public boolean checkInRange(int characterPosX, int characterPosY) {

        int pythagoras = ((characterPosX - getX()) * (characterPosX - getX())) + ((characterPosY - getY()) * (characterPosY - getY()));
        int radius_squared = radius * radius;
        System.out.println("Pythagoras number" + pythagoras);
        System.out.println("Radius Squared" + radius_squared);
        
        if (pythagoras < radius_squared) {
            return true;
        }            
        return false;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getBuildingAliveRounds() {
        return BuildingAliveRounds;
    }

    public BasicEnemy SpawnAbility(List<Pair<Integer, Integer>> orderedPath) {
        return null;
    }

    /**
     * Buffs the character depending on building
     */
    public void CharacterBuffAbility(Character character) {};

    public void DealDamageEnemies(BasicEnemy enemy){};

    public int CharacterBattleBuffAbility(Character character) {
        return 0;
    }
}
