package unsw.loopmania.Cards.PlacableBehaviour;

import java.util.List;

import org.javatuples.Pair;



public interface PlacableBehaviour {
    public boolean placable(int x, int y, List<Pair<Integer, Integer>> orderedPath);

    public boolean itemPlacable(int x, int y);
}
