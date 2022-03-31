package frc.robot.ClimbCommands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Extends or retracts the dynamic arms depending on the right stick
public class FineTuneArmsCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public FineTuneArmsCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);

  }
  
  @Override
  public void initialize() {
    SmartDashboard.putString("Current State", "VERTICAL_ADJUSTER");

  }

  @Override
  public void execute() {
    m_subsystem.ManualInputs(RobotContainer.getClimbController());
    if (m_subsystem.maxAngleUpSwitch.get() == true){
      m_subsystem.angleEncoder.reset();
    
    }
    if (m_subsystem.maxRetractSwitch.get() == true){
      m_subsystem.verticalEncoder.reset();
    }
  }

  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
      return false;
  }
}
