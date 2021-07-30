package unsw.loopmania.Enemies;


import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

public class Doggie extends BasicEnemy implements SpecialAbility{
    public Doggie(PathPosition pathPosition) {
        // Gives 1 gold and 1 xp
        // 2 battle radius, 2 support radius (nullifies since == to battle radius)
        super(pathPosition, 100, 40, "Doggie", 16, 16, 2, 2); 
    }
    /**
     * Doggie deals damage to character  
     */
    @Override
    public boolean dealDamage(Character character) {
        boolean check = false;
        super.dealDamage(character);
        check = doSpecial(character);
        return check;
    }

    /**
     * Stuns character
     * Skips characters attack and Enemy attacks twice
     */
    @Override
    public boolean doSpecial(Character character) {
        boolean check = false;
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 10){
            System.out.println("CHARACTER STUNNED!!");
            check = true;
            dealDamage(character);
        }

        return check;

    }
}
