package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClimberSubSystem;

public class AutoClimb extends ParallelCommandGroup {

  public AutoClimb(ClimberSubSystem m_climb) {
    addCommands(
        new SequentialCommandGroup(

        ));
  }
}