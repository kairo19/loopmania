package unsw.loopmania.Buildings;

import java.util.List;

import org.javatuples.Pair;

import unsw.loopmania.Enemies.BasicEnemy;

public interface SpecialBehaviour {
    public BasicEnemy SpawnAbility(List<Pair<Integer, Integer>> orderedPath);
}
