package frc.robot.teleop;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.teleop.subsystems.Drive;

public class Teleop {

    public static Drive drive = new Drive();
    private XboxController controller = new XboxController(1);

    public void TeleopPeriod() {
        drive.drive(controller);
        
        Scheduler.getInstance().run();
    }

}