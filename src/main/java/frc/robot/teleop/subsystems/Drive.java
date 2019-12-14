/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.teleop.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private static final int LEFT_MOTOR_1 = 0;
    private static final int LEFT_MOTOR_2 = 1;
    private static final int RIGHT_MOTOR_1 = 4;
    private static final int RIGHT_MOTOR_2 = 5;
    private static final int MIDDLE_MOTOR_1 = 2;
    private static final int MIDDLE_MOTOR_2 = 3;

    private KiwiDrivetrain drivetrain;

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void init() {
        Talon  L1 = new Talon(LEFT_MOTOR_1);
        Victor L2 = new Victor(LEFT_MOTOR_2);
        Talon  R1 = new Talon(RIGHT_MOTOR_1);
        Talon  R2 = new Talon(RIGHT_MOTOR_2);
        Talon  M1 = new Talon(MIDDLE_MOTOR_1);
        Talon  M2 = new Talon(MIDDLE_MOTOR_2);

        drivetrain = new KiwiDrivetrain(L1, L2, R1, R2, M1, M2);
    }

    public void drive(SuperJoystickModule controller) {
        final double xAxis = controller.getAxisWithDeadzone(0, 0, true);
        final double yAxis = controller.getAxisWithDeadzone(1, 0, false);
        final double zAxis = controller.getAxisWithDeadzone(2, 0, false) * 0.5;
        final double speedMod = 1.0;

        drivetrain.getKiwi(xAxis, yAxis, zAxis, speedMod);
    }
}
