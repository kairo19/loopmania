package unsw.loopmania;

import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Block;
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
    private IntegerProperty health;
    private IntegerProperty damage;
    private IntegerProperty totalDamage;
    private int buffedDamage;
    private int allies;
    private Weapon equippedWeapon;
    private Armour equippedArmour;
    private Helmet equippedHelmet;
    private Block equippedShield;
    private int alliesDamage;
    private DoubleProperty armourdefense;
    /*
    private Armour equippedArmour;
    private Helmet equippedHelmet;
    private Shield equippedShield;
    */

    public Character(PathPosition position) {
        super(position);
        this.allies = 0;
        this.health = new SimpleIntegerProperty(100);
        this.damage = new SimpleIntegerProperty(5);
        this.totalDamage = new SimpleIntegerProperty(5);
        this.buffedDamage = 0;
        this.alliesDamage = 0;
        this.equippedWeapon = null;
        this.equippedArmour = null;
        this.equippedHelmet = null;
        this.equippedShield = null;
        this.armourdefense = new SimpleDoubleProperty(0);
    }

    public IntegerProperty getHealthProperty() {
        return health;
    }
    public IntegerProperty getDamageProperty() {
        return damage;
    }
    public int getHealth() {
        return health.get();
    }
    public int getAlliesDamage() {
        return allies * 2;
    }
    public void setHealth(int health) {
        this.health.set(health);  
    }
    public int getDamage() {
        return damage.get();
    }
    public void setDamage(int damage) {
        this.damage.set(damage);
    }

    public void setTotalDamage(int buildingbuff) {
        this.totalDamage.set(getDamage() + buildingbuff + buffedDamage + getAlliesDamage());
    }

    public int getTotalDamage() {
        return totalDamage.get();
    }
    public DoubleProperty getArmourdefense() {
        return armourdefense;
    }
    public IntegerProperty getTotalDamageProperty() {
        return totalDamage;
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
        setArmourdefense(new SimpleDoubleProperty(armour.getDamageReduction()));
    }
    public void setArmourdefense(DoubleProperty armourdefense) {
        this.armourdefense = armourdefense;
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

    public void equipShield(Block shield) {
        this.equippedShield = shield;
    }

    public void unequipShield(){
        this.equippedShield = null;
    }

    public Block getShield(){
        return this.equippedShield;
    }

    public void setWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
    }

    public Weapon getWeapon(){
        return this.equippedWeapon;
    }

    public void removeWeapon() {
        this.equippedWeapon = null;
    }

    public double getArmourReduction(BasicEnemy basicEnemy) {
        return equippedArmour.damageReduction(basicEnemy);
    }

    public double getShieldReduction(BasicEnemy basicEnemy) {
        return equippedShield.damageReduction(basicEnemy);
    }

    public double getHelmetReduction(BasicEnemy basicEnemy) {
        return equippedHelmet.damageReduction(basicEnemy);
    }

    public int getHelmetDebuff() {
        return equippedHelmet.debuff();
    }

    public void setBuffedDamage(int buffedDamage) {
        this.buffedDamage = buffedDamage;
    }

    public void dealDamage(BasicEnemy enemy, int bonusDamage) {
        
        if (equippedWeapon != null) {
            equippedWeapon.damageBoost(this);
            
            equippedWeapon.doSpecial(enemy, this);
        }        

        int damageDealt = getDamage() + bonusDamage + buffedDamage + getAlliesDamage();
        
        enemy.setHealth(enemy.getHealth() - damageDealt);
        
    }
    public int getAllies() {
        return allies;
    }
    public void setAllies(int allies) {
        this.allies = allies;
    }

    public void lowerCritChance() {
    }    

}
