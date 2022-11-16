package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCommands.DriveForward;
import frc.robot.subsystems.DriveTrainSubsystem;


// Calls DriveBackward when the autonomous phase begins
public class AutonomousCommand extends SequentialCommandGroup {
  public DriveTrainSubsystem m_driveTrainSub;
  public AutonomousCommand(RobotContainer robotContainer, DriveTrainSubsystem subsystem) {
    m_driveTrainSub = subsystem;
    addRequirements(m_driveTrainSub);

    addCommands(
        //new DriveBackward(m_driveTrainSub),
        new DriveForward(m_driveTrainSub));
  }
}
