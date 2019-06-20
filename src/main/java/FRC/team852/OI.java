package FRC.team852;

import FRC.team852.util.fightstick.FightStickButtonAxis;
import FRC.team852.util.fightstick.FightStickButtonDigital;
import FRC.team852.util.fightstick.FightStickInput;
import FRC.team852.util.fightstick.FightStickPOVDirection;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    /**
     * CREATING BUTTONS
     * One type of button is a joystick button which is any button on a
     * joystick.
     * You create one by telling it which joystick it's on and which button
     * number it is.
     * Joystick stick = new Joystick(port);
     * Button button = new JoystickButton(stick, buttonNumber);
     * <p>
     * There are a few additional built in buttons you can use. Additionally,
     * by subclassing Button you can create custom triggers and bind those to
     * commands the same as any other Button.
     * <p>
     * // TRIGGERING COMMANDS WITH BUTTONS
     * Once you have a button, it's trivial to bind it to a button in one of
     * three ways:
     * <p>
     * Start the command when the button is pressed and let it run the command
     * until it is finished as determined by it's isFinished method.
     * button.whenPressed(new ElevatorMoveBangBang());
     * <p>
     * Run the command while the button is being held down and interrupt it once
     * the button is released.
     * button.whileHeld(new ElevatorMoveBangBang());
     * <p>
     * Start the command when the button is released and let it run the command
     * until it is finished as determined by it's isFinished method.
     * button.whenReleased(new ElevatorMoveBangBang());
     */
    public static XboxController xbox = new XboxController(0);
    public static Joystick fightStick = new Joystick(1);

    // Joystick buttons start at 1
    public static Button xboxA = new JoystickButton(xbox, 1);
    public static Button xboxB = new JoystickButton(xbox, 2);
    public static Button xboxX = new JoystickButton(xbox, 3);
    public static Button xboxY = new JoystickButton(xbox, 4);
    public static Button xboxLB = new JoystickButton(xbox, 5);
    public static Button xboxRB = new JoystickButton(xbox, 6);
    public static Button xboxBack = new JoystickButton(xbox, 7);
    public static Button xboxStart = new JoystickButton(xbox, 8);
    public static Button xboxLS = new JoystickButton(xbox, 9);
    public static Button xboxRS = new JoystickButton(xbox, 10);

    public static FightStickButtonDigital fightStickA = new FightStickButtonDigital(fightStick, 1, FightStickInput.input.medKick);
    public static FightStickButtonDigital fightStickB = new FightStickButtonDigital(fightStick, 2, FightStickInput.input.heavyKick);
    public static FightStickButtonDigital fightStickX = new FightStickButtonDigital(fightStick, 3, FightStickInput.input.medPunch);
    public static FightStickButtonDigital fightStickY = new FightStickButtonDigital(fightStick, 4, FightStickInput.input.heavyPunch);
    public static FightStickButtonDigital fightStickLB = new FightStickButtonDigital(fightStick, 5, FightStickInput.input.lightPunch);
    public static FightStickButtonDigital fightStickRB = new FightStickButtonDigital(fightStick, 6, FightStickInput.input.R1);
    public static FightStickButtonDigital fightStickShare = new FightStickButtonDigital(fightStick, 7, FightStickInput.input.share);
    public static FightStickButtonDigital fightStickOption = new FightStickButtonDigital(fightStick, 8, FightStickInput.input.option);
    public static FightStickButtonDigital fightStickL3 = new FightStickButtonDigital(fightStick, 9, FightStickInput.input.L3);
    public static FightStickButtonDigital fightStickR3 = new FightStickButtonDigital(fightStick, 10, FightStickInput.input.R3);

    public static FightStickButtonAxis fightStickLT = new FightStickButtonAxis(fightStick, 2, FightStickInput.input.lightKick);
    public static FightStickButtonAxis fightStickRT = new FightStickButtonAxis(fightStick, 3, FightStickInput.input.R2);

    public static FightStickPOVDirection POVUp = new FightStickPOVDirection(FightStickInput.input.POVtop);
    public static FightStickPOVDirection POVDown = new FightStickPOVDirection(FightStickInput.input.POVbot);
    public static FightStickPOVDirection POVcenter = new FightStickPOVDirection(FightStickInput.input.POVcenter);

    public OI() {

    }


}
