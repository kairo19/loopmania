package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;
import org.javatuples.Pair;

public class PlacableWeapon implements PlacableBehaviour{

    @Override
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean itemPlacable(int x, int y) {
        // TODO Auto-generated method stub
        if (x == 0 && y == 1) {
            return true;
        } else {
            return false;
        }
    }

    
    
}
