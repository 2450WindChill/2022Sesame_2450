package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Angles the arm down a set distance based off of a contant
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

  }

  @Override
  public void execute() {
    m_subsystem.AngleBackPID();
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.AngleAdjustmentMotor.set(0);
  }

  @Override
  public boolean isFinished() {
    if (m_subsystem.angleEncoder.getDistance() >= Constants.PIDExtendTolerance) {
      return true;
    } else {
      return false;
    }
  }
}
