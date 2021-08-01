package unsw.loopmania.item;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

/**
 * This class represents the Doggiecoin item.
 * @param x - item x coord position.
 * @param y - item y coord position.
 */

public class DoggieCoin extends StaticEntity {
    private IntegerProperty value;

    public DoggieCoin (SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.value = new SimpleIntegerProperty(100);
    }

    public IntegerProperty getValue() {
        return value;
    }

    /**
     * Gets the gold value of a Doggiecoin.
     */
    public int getValueProperty() {
        return value.get();
    }

    /**
     * Fluctuates the gold value of Doggiecoin based on whether Elan Muske is alive and randomness.
     * While Elan Muske is alive, increases the gold value by a multiple of 3.
     * @param elanMuskeAlive - whether Elan Muske enemy is alive.
     * @param round - number of path loops completed by character currently.
     */
    public void fluctuate(boolean elanMuskeAlive, int round) {
        if (round < 41 || round > 41) {
            // fluctuate randomly
            Random random = new Random();
            int fluctuation = random.nextInt(1) == 0 ? -1 : 1;
            float multiplier = random.nextFloat();
            value.set(Math.abs((int) (value.get() + 10000 * fluctuation * multiplier)));


            System.out.println("dog coin price: " + getValueProperty());

        } else if (elanMuskeAlive) {
            // increase
            value.set(value.get() * 3);

        } else if (!elanMuskeAlive) {
            // decrease
            value.set(value.get() / 3);

        }
    }
}
