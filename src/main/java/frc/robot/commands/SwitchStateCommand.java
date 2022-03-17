package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.ClimberSubsystem.State;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Switches the state of the arms form whatever it is to the other state
public class SwitchStateCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public SwitchStateCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    if (m_subsystem.state == State.VERTICAL_ADJUSTER) {
      m_subsystem.state = State.ANGLE_ADJUSTER;
      System.out.println("State: angle adjuster");
    } else {
        m_subsystem.state = State.VERTICAL_ADJUSTER;
        System.out.println("State: vertical adjuster");
    }
  }

  @Override
  public void execute(){
      
  }

  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
      return true;
  }
}
