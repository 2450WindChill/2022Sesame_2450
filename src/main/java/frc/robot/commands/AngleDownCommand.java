package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Currently angles the arm down while a button is held but will eventually: Angles the arm down a set distance based off of a contant
public class AngleDownCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public AngleDownCommand(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }
  public double goalDistance;

  @Override
  public void initialize() {
    goalDistance = m_subsystem.angleEncoder.getDistance() - Constants.angleDistance;
    System.out.println("Angle Down: Initializing goal distance to: " + goalDistance);
    System.out.println("Angle Down: Initializing encoder distance to: " + m_subsystem.angleEncoder.getDistance());
  }

  @Override
  public void execute() {
    m_subsystem.AngleAdjustmentMotor.set(-Constants.angleSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.AngleAdjustmentMotor.set(0);
  }

  @Override
  public boolean isFinished() {
    System.out.println("Angle Down: Encoder value: " + m_subsystem.angleEncoder.getDistance());
    System.out.println("Angle Down: Goal distance value: " + goalDistance);
    if (goalDistance > m_subsystem.angleEncoder.getDistance()) {
      System.err.println("Returning True");
      return true;
    } else {
      System.err.println("Returning False");
      return false;
    }
  }
}
