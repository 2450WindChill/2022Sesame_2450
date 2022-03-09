package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ManualClimbCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public ManualClimbCommand(ClimberSubsystem subsystem) {
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
    m_subsystem.DynamicArm1.set(0);
  }

  @Override
  public boolean isFinished() {
    boolean limitSwitchValue = m_subsystem.lernieUp.get();
    if (limitSwitchValue == true) {
      System.out.println("Limit switch activated!");
      m_subsystem.DynamicArm1.stopMotor();
      //m_subsystem.encoder1.reset();
      return true;
    } else {
      return false;
    }
  }
}
