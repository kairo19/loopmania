package unsw.loopmania;

/**
 * a slug enemy in the world
 */
public class SlugEnemy extends BasicEnemy {

    protected double[] drop_Table;
    
    public SlugEnemy(PathPosition position) {
        super(position);
        super.HP = 25;
        super.Attack = 5;
        super.xp_Reward = 10;
        super.gold_Reward = 10;
        super.crit_Rate = 0;
        super.battle_Radius = 1;
        super.support_Radius = 1;
        super.enemy_Name = "Slug";
        
        this.drop_Table = {0,0,0,0.1,0.05,0,0,0.05,0,0};
    }
    
    /**
     * Override for slug Movement
     */
    @Override
    public void move() {
        //Nothing as slug does not move.
    }
     

}
