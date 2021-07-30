package unsw.loopmania.Enemies;

import java.util.Random;

import unsw.loopmania.PathPosition;
import unsw.loopmania.Character;

public class Vampire extends BasicEnemy implements SpecialAbility {
    public Vampire(PathPosition pathPosition) {
        // Gives 4 gold and 4 xp
        // 3 battle radius, 5 support radius
        super(pathPosition, 50, 20, "Vampire", 8, 8, 3, 5);
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
        boolean check = false;
        Random r = new Random();
        int chance = r.nextInt(100);
        int randomHits = r.nextInt(5);
        if (chance < 10) {
            System.out.println("VAMPIRE CRITICAL STRIKE");
            for (int i = 0; i < randomHits; i++) {
                dealDamage(character);
            } 
        }

        return check;
    }
}
