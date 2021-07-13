package unsw.loopmania;

import java.util.Random;

/**
 * a basic form of enemy in the world
 */
public class BasicEnemy extends MovingEntity {
    
    protected int enemy_HP;
    protected int enemy_Attack;
    protected int xp_Reward;
    protected int gold_Reward;
    protected double crit_Rate;
    protected int battle_Radius;
    protected int support_Radius;
    protected String enemy_Name;

    // TODO = modify this, and add additional forms of enemy
    public BasicEnemy(PathPosition position) {
        super(position);
        this.HP = 0;
        this.Attack = 0;
        this.xp_Reward = 0;
        this.gold_Reward = 0;
        this.crit_Rate = 0;
        this.battle_Radius = 0;
        this.support_Radius = 0;
        this.enemy_Name = "Basic";
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
    
    /**
     * Getters
     */
    public int getbattleRadius() {
        return this.battle_Radius;
    }
    
    public int getsupportRadius() {
        return this.support_Radius;
    }
    
    public double getcritRate() {
        return this.crit_Rate;
    }
    
    public int getxpReward() {
        return this.xp_Reward;
    }
    
    public int getgoldReward() {
        return this.gold_Reward;
    }
    
    public String getenemyName() {
        return this.enemy_Name;
    }
    
    /**
     * Setters
     */
    public void setbattleRadius(double battle_radius) {
        this.battle_Radius = battle_radius;
    }
    
    public void setsupportRadius(double supp_radius) {
        this.support_Radius = supp_radius;
    }
    
    public void setcritRate(double crit_rate) {
        this.crit_Rate = crit_rate;
    }
    
    public void setxpReward(int xp_reward) {
        this.xp_Reward = xp_reward;
    }
    
    public void setgoldReward(int gold_reward) {
        this.gold_Reward = gold_reward;
    }
    
    
    
    
}
