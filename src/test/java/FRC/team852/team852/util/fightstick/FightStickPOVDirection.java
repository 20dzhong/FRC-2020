package FRC.team852.team852.util.fightstick;


import FRC.team852.util.fightstick.FightStickInput;
import edu.wpi.first.wpilibj.buttons.Trigger;
import FRC.team852.OI;

public class FightStickPOVDirection extends Trigger {
    private FRC.team852.util.fightstick.FightStickInput.input direction;

    public FightStickPOVDirection(FRC.team852.util.fightstick.FightStickInput.input input) {
        this.direction = input;
    }

    @Override
    public boolean get() {
        return FightStickInput.getJoystickEnumValue(OI.fightStick.getPOV()) == this.direction;
    }
}
