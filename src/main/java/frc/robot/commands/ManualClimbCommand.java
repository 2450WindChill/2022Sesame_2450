package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ManualClimbCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_climbsubsystem;

  public ManualClimbCommand(ClimberSubsystem subsystem) {
    m_climbsubsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_climbsubsystem.ManualExtendsInputs(RobotContainer.getXboxController());
  }

  @Override
  public void end(boolean interrupted) {
    m_climbsubsystem.DynamicArm1.set(0);
  }

  @Override
  public boolean isFinished() {
    // boolean limitSwitchValue = m_subsystem.limitSwitch1.get();
    // if (limitSwitchValue == true) {
    //   System.out.println("Limit switch activated!");
    //   m_subsystem.ExtendClimbArm.stopMotor();
    //   m_subsystem.encoder1.reset();
    //   return true;
    // } else {
    //   return false;
    // }
    return false;
  }
}
