package frc.robot.DriveCommands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Delay;
import edu.wpi.first.wpilibj2.command.CommandBase;

/*

Dumpy

*/


// Drives the robot backward for 1.5 seconds
public class DriveBackward extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrainSubsystem m_drivetrain;
  private Delay d;

  private long time = Constants.autoDriveTimeBackward;

  public DriveBackward(DriveTrainSubsystem subsystem) {
    m_drivetrain = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();
  }

  @Override
  public void initialize() {
    System.out.println("INITIALIZING ROBOT DRIVE BACKWARDS");
    d = new Delay(time);
  }

  @Override
  public void execute() {
    System.out.println("Executing robot drive backward");
    m_drivetrain.leftMotorGroup.set(Constants.autoDriveSpeedBackward);
    m_drivetrain.rightMotorGroup.set(Constants.autoDriveSpeedBackward);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("STOPPING ROBOT");
    m_drivetrain.leftMotorGroup.set(0);
    m_drivetrain.rightMotorGroup.set(0);
  }

  @Override
  public boolean isFinished() {
    return d.isExpired();
  }
}
