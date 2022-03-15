package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetPointCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;
  private double m_SetPoint = 0;
  private double offset;

  public SetPointCommand(double SetPoint, ClimberSubsystem m_Climb) {
    m_subsystem = m_Climb;
    m_SetPoint = SetPoint;

    addRequirements(m_Climb);
  }

  @Override
  public void initialize() {
      offset = 3;

  }

  @Override
  // If the distance of the arms is greater than the setpoint, then set the speed of the motors to extend
  public void execute() {
      if (m_subsystem.encoder1.getDistance() > m_SetPoint + offset) {
          m_subsystem.VerticalMotors.set(-Constants.climbSpeed);
      }
 // If the distance of the arms is less than the setpoint, then set the speed of the motors to retract
      else if (m_subsystem.encoder1.getDistance() < m_SetPoint - offset) {
          m_subsystem.VerticalMotors.set(Constants.climbSpeed);
      }
// If the arm distance is equal to the setpoint stop motors
      else {
          m_subsystem.VerticalMotors.set(0);
      }
    
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.VerticalMotors.set(0);
  }

  @Override
  
  public boolean isFinished() {
    // boolean limitSwitchValue = m_subsystem.lernieUp.get();
        // System.out.println("Value of limit switch: " + limitSwitchValue + "." + "Value of the encoder: " + m_subsystem.encoder1.getDistance());
        if (((m_SetPoint < m_subsystem.encoder1.getDistance() - offset)) && (m_SetPoint > m_subsystem.encoder1.getDistance() + offset)) {
            return true;
        }
        return false;
    }
  }