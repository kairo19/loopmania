package unsw.loopmania;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    private IntegerProperty health;
    private int damage;
    private int buffedDamage;
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
        /*
            TESTING FOR ALLIES. PLEASE CHANGE IT BACK LATER
        */
        this.allies = 0;
        this.health = new SimpleIntegerProperty(100);
        this.damage = 5;
        this.buffedDamage = 0;
        this.equippedWeapon = null;
        this.equippedArmour = null;
        this.equippedHelmet = null;
        this.equippedShield = null;
    }

    public IntegerProperty getHealthProperty() {
        return health;
    }
    public int getHealth() {
        return health.get();
    }
    public void setHealth(int health) {
        this.health.set(health);  
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
        //System.out.println("attach armour");
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
        //System.out.println("attach helmet");
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
        //System.out.println("attach shield");
        this.equippedShield = shield;
    }

    public void unequipShield(){
        this.equippedShield = null;
    }

    public Shield getShield(){
        return this.equippedShield;
    }

    public void setWeapon(Weapon weapon){
        //System.out.println("attach weapon");
        this.equippedWeapon = weapon;
    }

    public Weapon getWeapon(){
        return this.equippedWeapon;
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

    public void setBuffedDamage(int buffedDamage) {
        this.buffedDamage += buffedDamage;
    }

    public void dealDamage(BasicEnemy enemy, int bonusDamage) {
        
        if (equippedWeapon != null) {
            // added the buffed damage to buffedDamage
            equippedWeapon.damageBoost(this);
            // doing special attack to enemy
            equippedWeapon.doSpecial(enemy, this);
        }

        int alliesDamage = 2 * this.getAllies();

        System.out.println("current allies: " + this.getAllies());
        System.out.println("damage/character base: " + damage);
        System.out.println("bonus damage/buildings: " + bonusDamage);
        System.out.println("buffedDamage/Weapons: " + buffedDamage);
        System.out.println("alliesDamage: " + alliesDamage);


                        // base     buildings    weapons
        int damageDealt = damage + bonusDamage + buffedDamage + alliesDamage;

        /*
        // for helmet
        if (equippedHelmet != null) {
            System.out.println("helmet debuff" + getHelmetDebuff());
            damageDealt -= getHelmetDebuff();
        }
        */

        System.out.println("Enemy health:" + enemy.getHealth() + " - " + damageDealt);
        
        enemy.setHealth(enemy.getHealth() - damageDealt);
        
        // resetting it
        this.buffedDamage = 0;
    }
    public int getAllies() {
        return allies;
    }
    public void setAllies(int allies) {
        this.allies = allies;
    }

    public void lowerCritChance() {
        // do something here hehe xd
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


