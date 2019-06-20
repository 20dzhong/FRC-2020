package FRC.team852.team852.util.fightstick;


import FRC.team852.util.fightstick.FightStickButton;
import FRC.team852.util.fightstick.FightStickInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class FightStickButtonDigital extends JoystickButton implements FightStickButton {

    private FRC.team852.util.fightstick.FightStickInput.input button;

    public FightStickButtonDigital(Joystick fightStick, int buttonNumber, FRC.team852.util.fightstick.FightStickInput.input button) {
        super(fightStick, buttonNumber);
        this.button = button;
    }

    @Override
    public FightStickInput.input getButtonInputType() {
        return this.button;
    }
}