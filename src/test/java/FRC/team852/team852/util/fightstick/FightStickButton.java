package FRC.team852.team852.util.fightstick;

import FRC.team852.util.fightstick.FightStickInput;

/**
 * Simple, quick interface to ensure type similarities
 */

public interface FightStickButton {

    FightStickInput.input getButtonInputType();

    boolean get();

}
