package frc.robot.commands.ClimbCommands;

import frc.robot.Constants;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class SetPointCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;
  private double m_SetPoint = 0;
  private double offset;

  public SetPointCommand(ClimberSubsystem m_climb) {
    m_subsystem = m_climb;

    addRequirements(m_climb);
  }

  @Override
  public void initialize() {
      offset = 0.5;
      m_SetPoint = m_subsystem.verticalEncoder.getPosition();
  }

  @Override
  // If the distance of the arms is greater than the setpoint, then set the speed of the motors to extend
  public void execute() {
      System.out.println("Target: " + m_SetPoint);
      System.out.println("Current encoder value: " + m_subsystem.verticalEncoder.getPosition());
      if (m_subsystem.verticalEncoder.getPosition() > m_SetPoint + offset) {
          //m_subsystem.setVerticalSpeed(-Constants.correctionSpeed);
          m_subsystem.VerticalMotor.set(-Constants.correctionSpeed);
      }
 // If the distance of the arms is less than the setpoint, then set the speed of the motors to retract
      else if (m_subsystem.verticalEncoder.getPosition() < m_SetPoint - offset) {
          //m_subsystem.setVerticalSpeed(Constants.correctionSpeed);
          m_subsystem.VerticalMotor.set(Constants.correctionSpeed);
      }
// If the arm distance is equal to the setpoint stop motors
      else {
          //m_subsystem.setVerticalSpeed(0);
          m_subsystem.VerticalMotor.set(0);
      }
    
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.setVerticalSpeed(0);
    //m_subsystem.VerticalMotor.set(0);
  }

  @Override
  
  public boolean isFinished() {
      return false;
    }
  }