package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Extends or retracts the dynamic arms depending on the right stick
public class FineTuneArmCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public FineTuneArmCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);

  }
  
  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_subsystem.ManualInputs(RobotContainer.getXboxController());
    // Calling one string pot function to check for forward angleing
    //SmartDashboard.putNumber("String Vertical Potentiometer", m_subsystem.verticalPot.get());
    SmartDashboard.putNumber("String Angle Potentiometer", m_subsystem.anglePot.get() * Constants.potMultiplier);
  }

  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
      return false;
  }
}
