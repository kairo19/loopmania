package unsw.loopmania;

/**
 * a zombie enemy in the world
 */
public class ZombieEnemy extends BasicEnemy {

    protected double[] drop_Table;
    protected int spawnedEnemy;
    
    public ZombieEnemy(PathPosition position) {
        super(position);
        super.HP = 25;
        super.Attack = 10;
        super.xp_Reward = 20;
        super.gold_Reward = 20;
        super.crit_Rate = 0.1;
        super.battle_Radius = 2;
        super.support_Radius = 1;
        super.enemy_Name = "Zombie";
        
        this.spawnedEnemy = 0;
        this.drop_Table = {0,0.1,0,0.1,0.05,0,0,0.05,0.1,0};
    }
    
    /**
     * a critical attack.
     */    
    public void specialAttack() {
        //...
    }
    
    
    /**
     * Override for Zombie Movement
     */
    @Override
    public void move() {
        //...
    }
     
}
