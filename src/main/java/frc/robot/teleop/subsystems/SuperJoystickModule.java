import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;

/**
 * @author Jayden Chan
 * Date Created: April 18 2015
 * Last Updated: December 07 2015
 *
 * Class that adds functionality to the existing WPI Joystick class.
 */
public class SuperJoystickModule {
    private final Joystick joy;
    private boolean pre;

    //Constructing SuperControllerModule object with chosen joystick.
    public SuperJoystickModule(int port) {
        joy = new Joystick(port);
    }

    //Runs chosen object when chosen button is pressed. Does not repeat if held down.
    public void doWhenPressed(int button, Runnable action) {
        //Check if button is pressed and make sure it's not being held down
        if ((joy.getRawButton(button)) && (!pre)) {
            pre = true;
            action.run();
        }
        // Set the pre variable to false when button is released
        else if (!joy.getRawButton(button)) {
            pre = false;
        }
    }

    //Returns button press as boolean
    public boolean getButton(int button) {
        return joy.getRawButton(button);
    }

    //Returns axis value as double
    public double getAxis(int axis, boolean inversed) {
        //If inversed is selected return the negative of the axis
        if (inversed) {
            return -(joy.getRawAxis(axis));
            //If not return the normal value of the axis
        } else {
            return joy.getRawAxis(axis);
        }
    }

    //Sets the rumble modules in the controller. ayy lmao
    public void setRumble(float strength) {
        joy.setRumble(RumbleType.kLeftRumble, strength);
        joy.setRumble(RumbleType.kRightRumble, strength);
    }

    public boolean getDpad(int direction) {
        /*
         * Directions:
         * 1 = Up
         * 2 = Right
         * 3 = Down
         * 4 = Left
         */

        //Check if supplied direction is valid
        if (direction > 4 || direction < 1) {
            System.out.println("Invalid direction. State int 1-4");
            return false;
            // Check & return whether supplied direction is pressed or not.
        } else {
            switch (direction) {
                case 1:
                    return joy.getPOV(0) == 0;
                case 2:
                    return joy.getPOV(0) == 90;
                case 3:
                    return joy.getPOV(0) == 180;
                case 4:
                    return joy.getPOV(0) == 270;
            }
        }
        return false;
    }

    //Returns a double value of the chosen axis. If the axis is within the chosen deadzone, method returns 0.
    public double getAxisWithDeadzone(int axis, double deadzone, boolean inverted) {
        double axisthing;
        //Checks if axis is within deadzone and returns 0 if so
        if ((joy.getRawAxis(axis) <= deadzone) && (joy.getRawAxis(axis) >= -deadzone)) {
            axisthing = 0;
            //If axis isn't within deadzone returns the value of the axis
        } else {
            //Gets inverted value of axis
            if (inverted) {
                axisthing = -joy.getRawAxis(axis);
                //Gets raw value of axis
            } else {
                axisthing = joy.getRawAxis(axis);
            }
        }
        return axisthing;
    }
}
