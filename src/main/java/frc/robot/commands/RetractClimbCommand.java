package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RetractClimbCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubSystem m_subsystem;

  public RetractClimbCommand(ClimberSubSystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_subsystem.ExtendClimbArm.set(-Constants.climbSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.ExtendClimbArm.set(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}