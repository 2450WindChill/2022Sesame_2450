package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AngleDownCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public AngleDownCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_subsystem.AngleAdjustmentArm.set(-Constants.angleSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.AngleAdjustmentArm.set(0);
  }

  @Override
  public boolean isFinished() {
      return false;
  }
}
