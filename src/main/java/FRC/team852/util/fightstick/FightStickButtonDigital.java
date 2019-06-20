package FRC.team852.util.fightstick;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class FightStickButtonDigital extends JoystickButton implements FightStickButton {

    private FightStickInput.input button;

    public FightStickButtonDigital(Joystick fightStick, int buttonNumber, FightStickInput.input button) {
        super(fightStick, buttonNumber);
        this.button = button;
    }

    @Override
    public FightStickInput.input getButtonInputType() {
        return this.button;
    }
}