package unsw.loopmania.Buildings;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.List;

public class HerosCastleBuilding extends Building {
    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }  

    public int AddCycle(int Cycle) {
        return Cycle + 1;
    }

    public boolean PurchaseCycle(int Cycle) {
        if (Cycle % 3 == 0) {
            return true;
        } else if (Cycle == 1) {
            return true;
        }
        return false;
    }
    
    public void ShowStore(List<Item> Shop) {

    }
    public boolean ScaleStats(int Cycle) {
        if (Cycle % 10 == 0) {
            return true;
        }
        return false;
    }


}
