package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Currently angles the arm down while a button is held but will eventually: Angles the arm down a set distance based off of a contant
public class AngleUpCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public AngleUpCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }
  public double goalDistance;

  @Override
  public void initialize() {
    goalDistance = m_subsystem.encoder1.getDistance() + Constants.angleDistance;
  }

  @Override
  public void execute() {
    m_subsystem.AngleAdjustmentArm.set(Constants.angleSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.AngleAdjustmentArm.set(0);
  }

  @Override
  public boolean isFinished() {
    if (goalDistance < m_subsystem.encoder1.getDistance()) {
      return true;
    } else {
      return false;
    }
  }
}
