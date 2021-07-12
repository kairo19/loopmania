package unsw.loopmania;

interface battlephase {
    public void characterHitDamage(Character character, BasicEnemy enemy, LoopManiaWorld loopManiaWorld);
    public void enemyHitDamage(Character character, BasicEnemy enemy, LoopManiaWorld loopManiaWorld);

}

//hitDamage (get attack damage, apply attack damge to enemy entity)
// returns int

public class character implements battlephase{


    @Override
    public void characterHitDamage(Character character, BasicEnemy enemy, LoopManiaWorld loopManiaWorld) {
        
        
    }
    @Override
    public void enemyHitDamage(Character character, BasicEnemy enemy, LoopManiaWorld loopManiaWorld) {
        
        
    }
    
}

public class slime implements battlephase{

    @Override
    public void characterHitDamage(Character character, BasicEnemy enemy, LoopManiaWorld loopManiaWorld) {
        
        
    }

    @Override
    public void enemyHitDamage(Character character, BasicEnemy enemy, LoopManiaWorld loopManiaWorld) {
        
        
    }

}
