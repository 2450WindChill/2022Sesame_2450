package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClimberSubsystem;

// Work in Progress
public class AutoClimb extends ParallelCommandGroup {

  public AutoClimb(ClimberSubsystem m_climb) {
    addCommands(
        new SequentialCommandGroup(

        ));
  }
}