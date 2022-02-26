package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AutonomousCommand extends SequentialCommandGroup {
  public final DriveTrainSubsystem m_driveTrainSub = RobotContainer.m_driveTrainSub;

  public AutonomousCommand(RobotContainer robotContainer) {

    addCommands(
        new DriveBackward(m_driveTrainSub));
  }
}
