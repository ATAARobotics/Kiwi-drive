package frc.robot.teleop;

import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.teleop.subsystems.Drive;
import frc.robot.teleop.subsystems.SuperJoystickModule;

public class Teleop {

    private static final int JOYSTICK_PORT = 0;

    private static Drive drive = new Drive();
    private SuperJoystickModule driver = new SuperJoystickModule(JOYSTICK_PORT);

    public void TeleopPeriod() {
        drive.drive(driver);
        Scheduler.getInstance().run();
    }

    public void TeleopInit() {
        drive.init();
    }
}
