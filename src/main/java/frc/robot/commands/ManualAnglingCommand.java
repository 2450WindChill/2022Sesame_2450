package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ManualAnglingCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public ManualAnglingCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_subsystem.ManualExtendsInputs(RobotContainer.getXboxController());
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.DynamicArms.set(0);
  }

  @Override
  public boolean isFinished() {
      return false;
  }
}
