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
        maxCrit = r.nextInt(5);

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
        critDamage(character);
        return check;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean doSpecial(Character character) {
        boolean check = false;
        Random r = new Random();
        int chance = r.nextInt(100);
        if (chance < 50) {
            System.out.println("CHANCE HIT");
            crit = true;
            
        }

        return check;
    }

    /**
     * 
     * 
     */
    @Override
    public boolean critDamage(Character character) {
        
    
        if (crit) {
            System.out.println("VAMPIRE CRITICAL STRIKE");
            System.out.println("random r:" + maxCrit);
            if (counter > maxCrit) {
                counter = 0;
                crit = false;
                maxCrit = r.nextInt(5);
                return true;
            }
            counter ++;
            return true;
        }

        return false;
    }
}
