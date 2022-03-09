package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class ExtendClimbCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public ExtendClimbCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }
  public double goalDistance;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    goalDistance = m_subsystem.encoder1.getDistance() + Constants.extendDistance;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_subsystem.DynamicArm1.set(Constants.climbSpeed);
      
    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.DynamicArm1.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (goalDistance < m_subsystem.encoder1.getDistance()) {
      return true;
    } else {
      return false;
    }
  }
}