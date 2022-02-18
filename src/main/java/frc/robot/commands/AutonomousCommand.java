package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;


public class AutonomousCommand extends SequentialCommandGroup {

  public AutonomousCommand(Robot m_robot) {
    addCommands(
      new DriveForward(m_robot)
    );
  }
}
