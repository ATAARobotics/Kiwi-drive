import edu.wpi.first.wpilibj.SpeedController;
/**
 * @author Jayden
 * Date Created: April 17 2015
 * Last Updated: August 18 2015
 *
 * Class that can be used to construct working code for a kiwi drivetrain. Supports 3 or 6 CIM drivetrains.
 */
public class KiwiDrivetrain {
    SpeedController left, right, middle;

    //3 CIM kiwi drivetrain
    public KiwiDrivetrain(SpeedController left, SpeedController right, SpeedController middle) {
        this.left = left;
        this.right = right;
        this.middle = middle;
    }

    //6 CIM kiwi drivetrain
    public KiwiDrivetrain(SpeedController L1, SpeedController L2, SpeedController R1, SpeedController R2, SpeedController M1, SpeedController M2) {
        this.left = new SpeedControllerArray(new SpeedController[]{L1, L2});
        this.right = new SpeedControllerArray(new SpeedController[]{R1, R2});
        this.middle = new SpeedControllerArray(new SpeedController[]{M1, M2});
    }

    //Y axis moves forward and back, X axis moves left and right, Z axis rotates [relative to the robot]
    public void getKiwi(double xAxis, double yAxis, double zAxis, double speedMod) {
        middle.set(-((xAxis - zAxis) * speedMod));
        left.set((((0.5 * xAxis) - (Math.sqrt(3/2) * yAxis)) + zAxis) * speedMod);
        right.set((((0.5 * xAxis) + (Math.sqrt(3/2) * yAxis)) + zAxis) * speedMod);
    }

    // Drives robot relative to the field rather than relative to itself.
    public void getfKiwi(double xAxis, double yAxis, double zAxis, double speedMod, double theta) {
        double x, y, z;
        //Calculate required values for x, y, and z
        x = xAxis * Math.cos(theta) + yAxis * Math.sin(theta);
        y = -xAxis * Math.sin(theta) + yAxis * Math.cos(theta);
        z = zAxis;

        double cos30 = Math.cos(Math.PI / 6.0);
        //Apply those values to the motors
        middle.set(x + z);
        left.set(-x/2 + cos30 * (y) + z);
        right.set(-x/2 - cos30 * (y) + z);
    }
}
