package unsw.loopmania.Buildings;
import java.util.List;
import org.javatuples.Pair;


import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Character;
import unsw.loopmania.OccupiedBuildings;
import unsw.loopmania.PathPosition;
import unsw.loopmania.StaticEntity;
import unsw.loopmania.Enemies.BasicEnemy;

/**
 * This class represents buildings.
 * @param x - building x coord position.
 * @param y - building y coord position.
 * @param radius - building effective tile radius.
 * @param buildingAliveRounds - building round lifespan.
 */

public abstract class Building extends StaticEntity {
    private int radius;
    private int buildingAliveRounds;
    //private PathPosition position;
    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.radius = 0;
        this.buildingAliveRounds = 0;
    }   
    
    /**
     * Checks whether character is in range of building.
     * @param characterPosX - current character x position.
     * @param characterPosY - current character y position
     */
    public boolean checkInRange(int characterPosX, int characterPosY) {

        int pythagoras = ((characterPosX - getX()) * (characterPosX - getX())) + ((characterPosY - getY()) * (characterPosY - getY()));
        int radius_squared = radius * radius;        
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
        return buildingAliveRounds;
    }
    
    /**
     * Increase building round lifespan by 1 round.
     */
    public void addBuildingAlive() {
        buildingAliveRounds = buildingAliveRounds + 1;
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
