package unsw.loopmania.Enemies;
import unsw.loopmania.Character;

/**
 * Interface for enemy special attack abilities.
 * @param character - character entity.
 */

public interface SpecialAbility {
    public boolean doSpecial(Character character);
}
