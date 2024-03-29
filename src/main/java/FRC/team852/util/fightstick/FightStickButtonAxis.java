package FRC.team852.util.fightstick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class FightStickButtonAxis extends Trigger implements FightStickButton {

    private int axis;
    private FightStickInput.input button;
    private Joystick fightStick;

    public FightStickButtonAxis(Joystick fightStick, int axis, FightStickInput.input button) {
        this.fightStick = fightStick;
        this.axis = axis;
        this.button = button;
    }


    @Override
    public boolean get() {
        return fightStick.getRawAxis(this.axis) > 0.5;
    }


    @Override
    public FightStickInput.input getButtonInputType() {
        return this.button;
    }
}
