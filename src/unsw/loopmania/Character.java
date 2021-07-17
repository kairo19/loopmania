package unsw.loopmania;

import java.util.ArrayList;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.DefensiveItem;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
import unsw.loopmania.item.weapon.Weapon;

/**
 * represents the main character in the backend of the game world
 * @param health
 * @param damage
 * @param equippedSword
 * @param equippedShield
 * @param equippedArmour
 */

 
public class Character extends MovingEntity {
    // TODO = potentially implement relationships between this class and other classes
    private int health;
    private int damage;
    private int allies;                     // current placeholder
    private Weapon equippedWeapon;
    private Armour equippedArmour;
    private Helmet equippedHelmet;
    private Shield equippedShield;
    
    /*
    private Armour equippedArmour;
    private Helmet equippedHelmet;
    private Shield equippedShield;
    */

    public Character(PathPosition position) {
        super(position);
        this.allies = 0;
        this.health = 100;
        this.damage = 5;
        this.equippedWeapon = null;
        this.equippedArmour = null;
        this.equippedHelmet = null;
        this.equippedShield = null;
    }

    public int getHealth() {
        return this.health;
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
    public void gainAlly() {
        this.allies = this.allies + 1;
    }
    public void loseAlly() {
        this.allies = this.allies - 1;
    }
    public int getAlly() {
        return this.allies;
    }

    public void equipArmour(Armour armour) {
        this.equippedArmour = armour;
    }

    public void unequipArmour(){
        this.equippedArmour = null;
    }
    public Armour getArmour(){
        return this.equippedArmour;
    }

    // Helmet

    public void equipHelmet(Helmet helmet) {
        this.equippedHelmet = helmet;
    }

    public void unequipHelmet() {
        this.equippedHelmet = null;
    }

    public Helmet getHelmet() {
        return this.equippedHelmet;
    }

    // Shield

    public void equipShield(Shield shield) {
        this.equippedShield = shield;
    }

    public void unequipShield(){
        this.equippedShield = null;
    }

    public Shield getShield(){
        return this.equippedShield;
    }

    public void setWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
    }
    public void removeWeapon() {
        this.equippedWeapon = null;
    }

    public double getArmourReduction() {
        return equippedArmour.damageReduction();
    }

    public double getShieldReduction() {
        return equippedShield.damageReduction();
    }

    public double getHelmetReduction() {
        return equippedHelmet.damageReduction();
    }

    public int getHelmetDebuff() {
        return equippedHelmet.debuff();
    }

    public int lowerCritChance() {
        return 10;
    }

    public void dealDamage(BasicEnemy enemy, int bonusDamage) {
        
        if (equippedWeapon != null) {
            equippedWeapon.damageBoost(this);
            equippedWeapon.doSpecial(enemy, this);
        }
        int damageDealt = damage + bonusDamage;
        if (equippedHelmet != null) {
            damageDealt -= getHelmetDebuff();
        }
        
        System.out.println("Enemy health:" + enemy.getHealth() + " - " + damageDealt);
        
        enemy.setHealth(enemy.getHealth() - damageDealt);
        
        /*
        int damageDealt = damage;
        System.out.println("Enemy health:" + enemy.getHealth() + " - " + damageDealt);
        
        
        enemy.setHealth(enemy.getHealth() - damageDealt);
        */
    }

    

    

    /*
     //checkAttackDamage (check nearby boost, check equipped inventory)
    // returns int
    public void checkAttackdamage(int checkAttackDamage){

    }

    // check for nearby enemies, check equipped inventory
    // returns int
    public void checkRecievedamage(){

    }
    // receiveDamage( get damage recieved, apply damage to character)
    // returns int
    public receiveDamage(){

    }
    //checkNearbyBuildings(loop through buildings check if character is 
    //within radius if within radius return whatever)
    //return
    public checkNearbyBuildings(){

    }
    */
}


