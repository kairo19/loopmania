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

 
public class Character extends MovingEntity {
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
    }

    // 
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
    //this.health = this.health + health    
    }

    public void gainAlly() {
        /*
            this.allies = this.allies + 1;
        */
    }

    public void loseAlly() {
        /* 
            this.allies = this.allies - 1;
        */
    }

    public void equipArmour() {
        //this.equippedArmour = True;
    }

    public void unequipArmour(){
        //this.equippedArmour = False;
    }

    public void equipHelmet() {
        //this.equippeHelmet = True;
    }

    public void unequipHelmet(){
        //this.equippedHelmet = False;
    }

    public void equipShield() {
        //this.equippedShield = True;
    }

    public void unequipShield(){
        //this.equippedShield = False;
    }

    public void setWeapon(Weapon weapon){
        //this.equippedWeapon = weapon;
        //this.damage += weapon.damage;
    }

    public void removeWeapon() {
        //this.damage = this.damage - this.equippedWeapon.damage;
        //this.equippedWeapon = NULL;
        
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




