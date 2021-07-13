package unsw.loopmania;

/**
 * a vampire enemy in the world
 */
public class VampireEnemy extends BasicEnemy {

    protected double[] drop_Table;
    protected int crit_stacks;
    protected int crit_duration;
    
    
    public VampireEnemy(PathPosition position) {
        super(position);
        super.HP = 50;
        super.Attack = 20;
        super.xp_Reward = 100;
        super.gold_Reward = 100;
        super.crit_Rate = 0.2;
        super.battle_Radius = 3;
        super.support_Radius = 4;
        super.enemy_Name = "Vampire";
        
        this.crit_stacks = 0;
        this.drop_Table = {0.05,1,0.1,0.1,0.05,0,0.05,0.05,0,0};
    }
    
    /**
     * a critical attack.
     */    
    public void specialAttack() {
        crit_stacks++;
        //...
    }
    
    /**
     * reduce a turn of the special attack buff.
     */    
    public void critDurationReduction() {
        if (crit_duration > 0) {
            crit_duration = crit_duration - 1;
        }
    }
    
    /**
     * Override for Vampire Movement
     */
    @Override
    public void move() {
        //...
    }
     
}
