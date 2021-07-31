package unsw.loopmania.item;

import java.util.Random;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.StaticEntity;

public class DoggieCoin extends StaticEntity {
    private IntegerProperty value;

    public DoggieCoin (SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
        this.value = new SimpleIntegerProperty(0);
    }

    public IntegerProperty getValue() {
        return value;
    }

    public int getValueProperty() {
        return value.get();
    }

    public void fluctuate(boolean elanMuskeAlive, int round) {
        if (round < 41 || round > 41) {
            // fluctuate randomly
            Random random = new Random();
            int fluctuation = random.nextInt(1) == 0 ? -1 : 1;
            float multiplier = random.nextFloat();
            value.set((int) (value.get() + value.get() * fluctuation * multiplier));

        } else if (elanMuskeAlive) {
            // increase
            value.set(value.get() * 3);

        } else if (!elanMuskeAlive) {
            // decrease
            value.set(value.get() / 3);

        }
    }
}
