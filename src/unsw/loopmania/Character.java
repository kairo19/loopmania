package unsw.loopmania;

import java.util.ArrayList;

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
    private DefensiveItem equippedArmour;
    private DefensiveItem equippedHelmet;
    private DefensiveItem equippedShield;
    
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
    public DefensiveItem getArmour(){
        return this.equippedArmour;
    }

    // Helmet

    public void equipHelmet(Helmet helmet) {
        this.equippedHelmet = helmet;
    }

    public void unequipHelmet() {
        this.equippedHelmet = null;
    }

    public DefensiveItem getHelmetStatus() {
        return this.equippedHelmet;
    }

    // Shield

    public void equipShield(Shield shield) {
        this.equippedShield = shield;
    }

    public void unequipShield(){
        this.equippedShield = null;
    }

    public DefensiveItem getShieldStatus(){
        return this.equippedShield;
    }

    public void setWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
    }
    public void removeWeapon() {
        this.equippedWeapon = null;
    }

    public void addWeaponBaseDamage() {
        equippedWeapon.damageBoost(this);
    }

    public void dealDamage(BasicEnemy enemy) {
        equippedWeapon.damageBoost(this);
        equippedWeapon.doSpecial(enemy, this);
        int damagedealt = damage;
        damagedealt -= equippedHelmet.damageReduction(enemy);
        // enemy.setHealth(enemy.getHealth() - this.getDamage());
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


