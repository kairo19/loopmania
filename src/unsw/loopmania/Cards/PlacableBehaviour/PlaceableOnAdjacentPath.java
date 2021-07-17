package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;
import org.javatuples.Pair;

public class PlaceableOnAdjacentPath implements PlacableBehaviour {

    @Override
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath) {
        for (Pair<Integer,Integer> p: orderedPath) {
            if (p.getValue0() == x && p.getValue1() == y) {
                System.out.println("PlaceOn ADJACENT FAILED");
                return false;

            }
        }
        System.out.println("PlaceOn ADJACENT PASSED");
        return true;

       
    }
}
