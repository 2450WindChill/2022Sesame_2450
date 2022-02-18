/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Delay;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class DriveForward extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Robot m_robot;
  private Delay d;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */

  private long time = Constants.autoDriveTime;

  public DriveForward(Robot robot) {
    m_robot = robot;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();
  }

  // Called when the command is initially scheduled.
  // When initializing set delay
  @Override
  public void initialize() {
    System.out.println("INITIALIZING ROBOT");
    d = new Delay(time);
  }

  // Called every time the scheduler runs while the command is scheduled.
  // When executing the robot, set the speeds to the constants for speed
  @Override
  public void execute() {
    System.out.println("Executing robot");
    m_robot.leftMotorGroup.set(Constants.autoDriveSpeed);
    m_robot.rightMotorGroup.set(Constants.autoDriveSpeed);
  }

  // Called once the command ends or is interrupted.
  // When done executing, stop the robot
  @Override
  public void end(boolean interrupted) {
    System.out.println("STOPPING ROBOT");
    m_robot.leftMotorGroup.set(0);
    m_robot.rightMotorGroup.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return d.isExpired();
  }
}

