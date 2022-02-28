package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ManualExtend extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final ClimberSubsystem m_subsystem;

  public ManualExtend(ClimberSubsystem subsystem) {
    m_subsystem = subsystem;

    addRequirements(subsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    m_subsystem.ManualExtendsInputs(RobotContainer.getXboxController());
    m_subsystem.ExtendClimbArm.set(Constants.climbSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_subsystem.ExtendClimbArm.set(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
