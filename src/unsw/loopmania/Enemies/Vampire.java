package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

public class Vampire extends BasicEnemy implements SpecialAbility {

    private boolean crit;
    private int counter;
    private Random r;
    private int maxCrit;


    public Vampire(PathPosition pathPosition) {
        // Gives 4 gold and 4 xp
        // 3 battle radius, 5 support radius
        super(pathPosition, 50, 20, "Vampire", 8, 8, 3, 5);
        crit = false;
        r = new Random();
        maxCrit = r.nextInt(5) + 1;

    }

    /**
     * 
     * 
     */
    @Override
    public boolean dealDamage(Character character) {
        boolean check = false;
        super.dealDamage(character);
        check = doSpecial(character);
        return check;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean doSpecial(Character character) {
        Random r = new Random();
        int chance = r.nextInt(100);
        if (chance < 10) {
            
            crit = true;
            return true;
            
        }

        return false;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean critDamage(Character character) {
        
    
        if (crit) {
            System.out.println("random r:" + maxCrit);
            if (counter >= maxCrit) {
                counter = 0;
                crit = false;
                System.out.println("CHANCE CHANGED");
                maxCrit = r.nextInt(5) + 1;
                return false;
            }
            counter ++;
            return true;
        }

        return false;
    }
}
