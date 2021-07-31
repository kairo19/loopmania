package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.MovingEntity;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {
    // TODO = modify this, and add additional forms of enemy
    private int health;
    private int damage;
    private String type;
    private int goldReward;
    private int xpReward;
    private int battleRadius;
    private int supportRadius;

    public BasicEnemy(PathPosition position) {
        super(position);
    }

    public BasicEnemy(PathPosition position, int health, int damage, String type,
                        int goldReward, int xpReward, int battleRadius, int supportRadius) {
        this(position);
        this.health = health; 
        this.damage = damage;
        this.type = type;
        this.goldReward = goldReward;
        this.xpReward = xpReward;
        this.battleRadius = battleRadius;
        this.supportRadius = supportRadius;
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

    public int getBattleRadius() {
        return this.battleRadius;
    }

    public int getSupportRadius() {
        return this.supportRadius;
    }

    public int getGold() {
        return this.goldReward;
    }

    public int getXP() {
        return this.xpReward;
    }

    public void dealDamage(Character character) {
        
        int damageDealt = this.damage;
        
        if (character.getArmour() != null) {
            damageDealt *= character.getArmourReduction();
        }

        if (character.getShield() != null) {
            damageDealt -= character.getShieldReduction();
            if (this.type.equals("Vampire")) {
                character.lowerCritChance();
            }
        }

        if (character.getHelmet() != null) {
            damageDealt -= character.getHelmetReduction();
        }
        if (damageDealt < 0) {
            damageDealt = 0;
        }
        System.out.println("Character health:" + character.getHealth() + " - " + damageDealt);
        
        character.setHealth(character.getHealth() - damageDealt);
        
        
    }

    public boolean critDamage(Character character) {
        return false;
    }
    public boolean isBoss() {
        return false;
    }

    public boolean doSpecial(Character character) {
        return false;
    }
    
}
