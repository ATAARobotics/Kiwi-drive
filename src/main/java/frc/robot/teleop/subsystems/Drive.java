/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.teleop.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX zeroDegreeMotor = new WPI_TalonSRX(0); 
  private WPI_TalonSRX oneTwentyDegreeMotor = new WPI_TalonSRX(1); 
  private WPI_TalonSRX twoFourtyDegreeMotor = new WPI_TalonSRX(2); 

  private double theta, rawAngle, angle, speed, turn;
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  public void drive(XboxController controller) {

    try {
      theta = Math.atan2(controller.getY(Hand.kLeft), controller.getX(Hand.kLeft));
      rawAngle = Math.toDegrees(theta);
      angle = (rawAngle >= 90) ? rawAngle - 90 : rawAngle + 270;
    } catch(Exception e) {
      angle = (controller.getY(Hand.kLeft) > 0) ? 0 : 180;
    }

    speed = Math.hypot(controller.getX(Hand.kLeft), controller.getY(Hand.kLeft));

    turn = controller.getY(Hand.kRight);

    System.out.println("Angle: " + angle + " Y: " + controller.getY(Hand.kLeft) + " X: " + controller.getX(Hand.kLeft));

  }

}
