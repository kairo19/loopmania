package unsw.loopmania;

import java.util.ArrayList;

/**
 * represents the main character in the backend of the game world
 * @param health
 * @param damage
 * @param equippedSword
 * @param equippedShield
 * @param equippedArmour
 */

 
public class Character extends MovingEntity implements battlephase {
    // TODO = potentially implement relationships between this class and other classes
    private int health;
    private int damage;
    private int allies;
    //private Weapon equippedWeapon;
    private boolean equippedArmour;
    private boolean equippedHelmet;
    private boolean equippedShield;
    
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
        this.equippedArmour = false;
        this.equippedHelmet = false;
        this.equippedShield = false;
    }

    // Health

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = this.health + health;    
    }

    // Damage

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Allies

    public void gainAlly() {
        this.allies = this.allies + 1;
    }

    public void loseAlly() {
        this.allies = this.allies - 1;
    }

    public int getAlly() {
        return this.allies;
    }

    // Armour

    public void equipArmour() {
        this.equippedArmour = true;
    }

    public void unequipArmour(){
        this.equippedArmour = false;
    }

    public boolean getArmourStatus(){
        return this.equippedArmour;
    }

    // Helmet

    public void equipHelmet() {
        this.equippedHelmet = true;
    }

    public void unequipHelmet(){
        this.equippedHelmet = false;
    }

    public boolean getHelmetStatus(){
        return this.equippedHelmet;
    }

    // Shield

    public void equipShield() {
        this.equippedShield = true;
    }

    public void unequipShield(){
        this.equippedShield = false;
    }

    public boolean getShieldStatus(){
        return this.equippedShield;
    }

    //Weapons
    /*
    public void setWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
    }
   

    public void removeWeapon(Weapon weapon) {
        this.damage = this.damage - weapon.damageBoost;
        this.equippedWeapon = NULL;
        
    }
    */
    
    @Override
    public void HitDamage(Character character, BasicEnemy enemy) {
        
        enemy.setHealth(enemy.getHealth() - this.getDamage());
        
    }

    @Override
    public void buildingInteraction(Character character, BasicEnemy enemy, Building building){
        
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




