package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;
import org.javatuples.Pair;

public class PlacableOnPath implements PlacableBehaviour{

    @Override
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath) {
        for (Pair<Integer,Integer> p: orderedPath) {
            if (p.getValue0() == x && p.getValue1() == y) {
                System.out.println("PlaceOn PATH PASSED");
                return true;
                
            }
        }
        System.out.println("PlaceOn PATH FAILED");
        return false;
        
    }   
                
}
