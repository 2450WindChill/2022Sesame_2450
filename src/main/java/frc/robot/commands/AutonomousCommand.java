package frc.robot.commands;

import org.ejml.simple.ConvertToImaginaryException;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// Calls DriveBackward when the autonomous phase begins
public class AutonomousCommand extends SequentialCommandGroup {
  public final DriveTrainSubsystem m_driveTrainSub = RobotContainer.m_driveTrainSub;
  public final ShooterSubsystem m_shootSub = RobotContainer.m_shootSub;
  public final ConveyorSubsystem m_conveyorSub = RobotContainer.m_conveyorSub;

  public AutonomousCommand(RobotContainer robotContainer) {

    addCommands(
        new DriveForward(m_driveTrainSub),

        new TurnAround(m_driveTrainSub),

        new AutoFullShoot(m_shootSub, m_conveyorSub));
  }
}
