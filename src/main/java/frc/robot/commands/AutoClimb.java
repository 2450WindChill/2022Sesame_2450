package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClimberSubsystem;
// When on ground and attached to mid bar, this command will automatically get the robot to the high bar
// Could theoretically be used to get robot from high bar to traversal but swing would be an issue
public class AutoClimb extends SequentialCommandGroup {
  public AutoClimb(ClimberSubsystem m_climb) {
    addCommands(
      new SetRetractArmsCommand(m_climb),

      new SwitchStateCommand(m_climb),

      new AngleDownCommand(m_climb),
      
      new SwitchStateCommand(m_climb),

      new SetExtendArmsCommand(m_climb),

      new SwitchStateCommand(m_climb),

      new AngleUpCommand(m_climb),
  
      new SetRetractArmsCommand(m_climb)
    );
  }
}