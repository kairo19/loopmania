package unsw.loopmania;

import java.util.Random;

import unsw.loopmania.MovingEntity;
import unsw.loopmania.PathPosition;

/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {
    // TODO = modify this, and add additional forms of enemy
    private int health;
    private int damage;
    private String type;
    public BasicEnemy(PathPosition position) {
        super(position);
    }

    public BasicEnemy(PathPosition position, int health, int damage, String type) {
        this(position);
        this.health = health; 
        this.damage = damage;
        this.type = type;
    }

    /**
     * move the enemy
     */
    public void move(){
        // TODO = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    // public void dealDamage(Character character) {
    //     character.setDamage(character.getDamage() - this.damage);
    // }
}
