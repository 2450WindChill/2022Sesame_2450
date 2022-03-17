package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Switches the state of the arms form whatever it is to the other state
public class StringPotentiometerTest extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public StringPotentiometerTest(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {

    
  }

  @Override
  public void execute(){
    System.out.println("Value of string potentiometer: " + m_subsystem.pot.get() * 1000000);
  }

  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
    //  if (m_subsystem.pot.get() > something) {
    //    m_subsystem.VerticalMotors.set(0);
    //  }
      return false;
  }
}
