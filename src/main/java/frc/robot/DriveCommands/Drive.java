package frc.robot.DriveCommands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Puts xbox inputs into the curvature drive
public class Drive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  public final DriveTrainSubsystem m_driveTrainSub;

  public Drive(DriveTrainSubsystem subsystem) {
    m_driveTrainSub = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_driveTrainSub.takeXboxInputs(RobotContainer.getDriveController());
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
