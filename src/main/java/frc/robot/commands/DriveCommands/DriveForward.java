package frc.robot.commands.DriveCommands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Delay;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveForward extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveTrainSubsystem m_drivetrain;
  private Delay d;

  private long time = Constants.autoDriveTimeForward;

  public DriveForward(DriveTrainSubsystem subsystem) {
    m_drivetrain = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();
  }

  @Override
  public void initialize() {
    //System.out.println("INITIALIZING ROBOT DRIVE FORWARDS");
    d = new Delay(time);
    
  }

  @Override
  public void execute() {
    //System.out.println("Executing robot drive forward");
    m_drivetrain.leftMotorGroup.set(Constants.autoDriveSpeedForward);
    m_drivetrain.rightMotorGroup.set(Constants.autoDriveSpeedForward);
  }

  @Override
  public void end(boolean interrupted) {
    //System.out.println("STOPPING ROBOT");
    m_drivetrain.leftMotorGroup.set(0);
    m_drivetrain.rightMotorGroup.set(0);
  }

  @Override
  public boolean isFinished() {
    return d.isExpired();
  }
}
