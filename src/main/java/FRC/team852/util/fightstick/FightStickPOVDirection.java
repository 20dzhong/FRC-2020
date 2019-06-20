package FRC.team852.util.fightstick;


import edu.wpi.first.wpilibj.buttons.Trigger;
import FRC.team852.OI;

public class FightStickPOVDirection extends Trigger {
    private FightStickInput.input direction;

    public FightStickPOVDirection(FightStickInput.input input) {
        this.direction = input;
    }

    @Override
    public boolean get() {
        return FightStickInput.getJoystickEnumValue(OI.fightStick.getPOV()) == this.direction;
    }
}
