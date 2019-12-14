import edu.wpi.first.wpilibj.SpeedController;
/**
 * @author Jayden Chan
 * Date Created: April 17 2015
 * Last Updated: April 20 2015
 *
 * Class that constructs an array of speed controllers that can all be set to the same value. Useful for arcade drivetrain class construction.
 */
public class SpeedControllerArray implements SpeedController {
    private final SpeedController[] array;

    public SpeedControllerArray(SpeedController[] group) {
        if(group == null) {
            throw new NullPointerException("Array provided was null.");
        }
        this.array = group;
    }

    @Override
    public void disable() {
        for(int x = 0; x < array.length; x++) {
            array[x].disable();
        }
    }

    @Override
    public void pidWrite(double output) {
        for(int x = 0; x < array.length; x++) {
            array[x].pidWrite(output);
        }
    }

    @Override
    public double get() {
        return 0;
    }

    @Override
    public void set(double speed, byte syncGroup) {

    }


    public void setInverted() {

    }

    @Override
    public void set(double speed) {
        for(int x = 0; x < array.length; x++) {
            array[x].set(speed);
        }

    }

    @Override
    public void setInverted(boolean isInverted) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getInverted() {
        // TODO Auto-generated method stub
        return false;
    }

}
