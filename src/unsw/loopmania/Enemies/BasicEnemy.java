package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.MovingEntity;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

/**
 * This class represents a basic enemy.
 * @param position - enemy position on path.
 * @param health - enemy health points.
 * @param damage - enemy attack damage points.
 * @param type - enemy name.
 * @param goldReward - gold rewarded for defeating enemy.
 * @param xpReward - xp rewarded for defeating enemy.
 * @param battleRadius - combat trigger radius measured in number of tiles.
 * @param supportRadius - support trigger radius measured in number of tiles.
 */

public class BasicEnemy extends MovingEntity {
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
     * Move the enemy along the path.
     */
    public void move() {
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

    /**
     * Deals damage to the character.
     * @param character - character entity.
     */
    public void dealDamage(Character character) {
        
        int damageDealt = this.damage;
        
        if (character.getArmour() != null) {
            damageDealt *= character.getArmourReduction(this);
        }

        if (character.getShield() != null) {
            damageDealt -= character.getShieldReduction(this);
            if (this.type.equals("Vampire")) {
                character.lowerCritChance();
            }
        }

        if (character.getHelmet() != null) {
            damageDealt -= character.getHelmetReduction(this);
        }
        if (damageDealt < 0) {
            damageDealt = 0;
        }
        System.out.println("Character health:" + character.getHealth() + " - " + damageDealt);
        
        character.setHealth(character.getHealth() - damageDealt);
             
    }

    /**
     * Returns whether the enemy does crit damage.
     * @param character - character entity.
     */
    public boolean critDamage(Character character) {
        return false;
    }
    
    /**
     * Returns whether the enemy is a boss.
     */
    public boolean isBoss() {
        return false;
    }

    /**
     * Returns whether the enemy has a special attack.
     * @param character - character entity.
     */
    public boolean doSpecial(Character character) {
        return false;
    }
    
}
