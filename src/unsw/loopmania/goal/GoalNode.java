package unsw.loopmania.goal;

import unsw.loopmania.LoopManiaWorld;

import javafx.beans.property.BooleanProperty;

public interface GoalNode {
    public boolean hasMetGoal(LoopManiaWorld loopManiaWorld);
}
