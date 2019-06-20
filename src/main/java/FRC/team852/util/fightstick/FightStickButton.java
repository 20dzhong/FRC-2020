package FRC.team852.util.fightstick;

/**
 * Simple, quick interface to ensure type similarities
 */

public interface FightStickButton {

    FightStickInput.input getButtonInputType();

    boolean get();

}
