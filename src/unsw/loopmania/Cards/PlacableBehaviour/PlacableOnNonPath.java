package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;
import org.javatuples.Pair;

public class PlacableOnNonPath implements PlacableBehaviour{

    @Override
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath) {
        for (Pair<Integer,Integer> p: orderedPath) {
            if (p.getValue0() == x && p.getValue1() == y) {
                System.out.println("PlaceOnNONPATH FAILED");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean itemPlacable(int x, int y) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
