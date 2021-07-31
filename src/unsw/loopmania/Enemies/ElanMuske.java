package unsw.loopmania.Enemies;

import unsw.loopmania.Character;
import unsw.loopmania.PathPosition;

public class ElanMuske extends BasicEnemy implements SpecialAbility{
    public ElanMuske(PathPosition pathPosition) {
        // Gives 1 gold and 1 xp
        // 2 battle radius, 2 support radius (nullifies since == to battle radius)
        super(pathPosition, 200, 60, "ElanMuske", 32, 32, 2, 2); // damage and health current placeholders
    }

    @Override
    public void dealDamage(Character character) {
        super.dealDamage(character);
        doSpecial(character);

    }
    
    @Override
    public boolean doSpecial(Character character) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean isBoss() {
        return true;
    }
}
